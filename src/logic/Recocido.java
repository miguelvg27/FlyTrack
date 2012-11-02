/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import beans.Aeropuerto;
import beans.Envio;
import beans.Parametro;
import beans.Vuelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author miguelavg
 */
public class Recocido {

    private int kSA;                            // iteraciones por temperatura
    private double temperaturaInicial;          // temperatura inicial
    private double temperatura;                 // temperatura actual
    private double temperaturaFinal;            // temperatura final
    private double alfaSA;                      // coeficiente de reducción de temperatura
    private double alfaGrasp;                   // coeficiente de relajación del grasp construcción
    private double pParada;                     // porcentaje de malas iteraciones para parar
    private int intentos;                       // intentos de malos grasp
    private double costoAlmacen;
    private Envio envio;                        // envío a realizar
    private List<Aeropuerto> aeropuertos;            // todos los vuelos
    private ArrayList<Vuelo> solucion;          // ruta solución
    private ArrayList<Vuelo> alterado;          // ruta alterada

    public Recocido(int kSA, double temperaturaInicial, double temperaturaFinal, double alfaSA, double alfaGrasp, double pParada, int intentos, Envio envio, List<Aeropuerto> aeropuertos, double costoAlmacen) {
        this.kSA = kSA;
        this.temperaturaInicial = temperaturaInicial;
        this.temperatura = temperaturaInicial;
        this.temperaturaFinal = temperaturaFinal;
        this.alfaSA = alfaSA;
        this.alfaGrasp = alfaGrasp;
        this.pParada = pParada;
        this.intentos = intentos;
        this.envio = envio;
        this.aeropuertos = aeropuertos;
        this.costoAlmacen = costoAlmacen;
    }

    private double enfriamiento() {
        this.temperatura = this.alfaSA * this.temperatura;
        return this.temperatura;
    }

    private int estadoEnergia(ArrayList<Vuelo> vuelos, Date llegada) {
        try {
            Vuelo vuelo;
            long milisec;
            double iCostoAlmacen;
            double iCostoEnvio;
            double costoAlmacen = 0;
            double costoEnvio = 0;
            double costo;

            double pLleno;
            double pCapacidad;
            Random rnd = new Random();

            for (int i = 0; i < vuelos.size(); i++) {
                vuelo = vuelos.get(i);
                milisec = vuelo.getFechaSalida().getTime() - llegada.getTime();

                iCostoAlmacen = this.costoAlmacen * (double) milisec / (60 * 60000);
                costoAlmacen = costoAlmacen + iCostoAlmacen;

                pLleno = 0.9; // 0.8 + rnd.nextDouble() * 0.2;
                pCapacidad = Math.max(pLleno * vuelo.getCapacidadMax(), vuelo.getCapacidadActual());

                iCostoEnvio = (double) vuelo.getAlquiler() / pCapacidad;
                costoEnvio = costoEnvio + iCostoEnvio;
            }

            costo = costoEnvio + costoAlmacen;
            return (int) costo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private double boltzmann(double dEnergia, double temperatura) {
        return Math.exp(-1 * (dEnergia / temperatura));
    }

    private ArrayList<Vuelo> liteGrasp(Aeropuerto aOrigen, Aeropuerto aDestino, Date fecha, double alfa) {
        try {
            Aeropuerto aActual = aOrigen;
            Random rnd = new Random();

            Date dActual = fecha;
            int iActual = aActual.getIdAeropuerto();
            int iFinal = aDestino.getIdAeropuerto();

            ArrayList<Vuelo> posibles;
            ArrayList<Vuelo> construccion = new ArrayList<Vuelo>();
            ArrayList<Vuelo> rcl;
            Vuelo aleatorio;

            int beta = Integer.MAX_VALUE;
            int tau = 0;
            int e;

            // Mientras no hayamos llegado al final...

            while (iActual != iFinal && aActual.getCapacidadMax() > aActual.getCapacidadActual()) {
                posibles = new ArrayList<Vuelo>();

                // Calcular los vuelos posibles, el beta y el tau

                for (int i = 0; i < aActual.getVuelosSalida().size(); i++) {
                    Vuelo vuelo = aActual.getVuelosSalida().get(i);

                    if (vuelo.getFechaSalida().after(dActual)
                            && vuelo.getCapacidadMax() > vuelo.getCapacidadActual()
                            && aDestino.getCapacidadMax() > aDestino.getCapacidadActual() + vuelo.getCapacidadActual()) {
                        posibles.add(vuelo);
                        ArrayList<Vuelo> wrap = new ArrayList<Vuelo>();
                        wrap.add(vuelo);
                        e = estadoEnergia(wrap, dActual);

                        if (e < beta) {
                            beta = e;
                        }
                        if (e > tau) {
                            tau = e;
                        }

                    }

                }

                rcl = new ArrayList<Vuelo>();

                for (int i = 0; i < posibles.size(); i++) {
                    Vuelo vuelo = posibles.get(i);
                    ArrayList<Vuelo> wrap = new ArrayList<Vuelo>();
                    wrap.add(vuelo);
                    e = estadoEnergia(wrap, dActual);

                    if (beta <= e && e <= beta + alfa * (tau - beta)) {
                        rcl.add(vuelo);
                    }
                }

                if (rcl.isEmpty()) {
                    return null;
                }

                aleatorio = rcl.get(rnd.nextInt(rcl.size()));
                construccion.add(aleatorio);

                aActual = aleatorio.getDestino();
                iActual = aActual.getIdAeropuerto();
                dActual = aleatorio.getFechaLlegada();
                beta = Integer.MAX_VALUE;
                tau = 0;

            }

            if (iActual != iFinal) {
                return null;
            }

            return construccion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private ArrayList<Vuelo> alteracionMolecular() {
        try {
            Random rnd = new Random();
            Date fecha;

            this.alterado = new ArrayList<Vuelo>();
            int iAleatorio = rnd.nextInt(this.solucion.size());
            Vuelo aleatorio = this.solucion.get(iAleatorio);
            Aeropuerto pivote = aleatorio.getOrigen();

            for (int i = 0; i < iAleatorio; i++) {
                alterado.add(this.solucion.get(i));
            }

            if (iAleatorio > 0) {
                fecha = solucion.get(iAleatorio - 1).getFechaLlegada();
            } else {
                fecha = envio.getFechaRegistro();
            }

            ArrayList<Vuelo> construccion = liteGrasp(pivote, envio.getDestino(), fecha, this.alfaGrasp);

            if (construccion == null) {
                this.alterado = null;
                return null;
            }

            for (int i = 0; i < construccion.size(); i++) {
                this.alterado.add(construccion.get(i));
            }

            return alterado;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Vuelo> simular() {
        try {
            Random rnd = new Random();
            long tiempoInicio, tiempoFin;
            int dEnergia;
            double b, p;

            int iteraciones = this.kSA * (int) (Math.log(this.temperaturaFinal / this.temperaturaInicial) / Math.log(this.alfaSA));
            int outIt = 0;

            tiempoInicio = new Date().getTime();

            for (int i = 0; i < this.intentos; i++) {
                this.solucion = liteGrasp(envio.getOrigen(), envio.getDestino(), envio.getFechaRegistro(), this.alfaGrasp);
                if (this.solucion != null) {
                    break;
                }
            }

            if (this.solucion == null) {
                // System.out.println("¡No hay solución inicial!");
                return null;
            }

            // System.out.println("Solución inicial: ");
            // tiempoFin = new Date().getTime();
            // resultado = new Resultado(this.envio, tiempoFin - tiempoInicio, estadoEnergia(this.solucion, this.envio.getFecha()), this.solucion);
            // resultado.imprimirResultados();

            while (this.temperatura > this.temperaturaFinal) {

                for (int k = 0; k < this.kSA; k++) {

                    for (int i = 0; i < this.intentos; i++) {
                        this.alteracionMolecular();
                        if (this.alterado != null) {
                            break;
                        }
                    }

                    if (this.alterado == null) {
                        outIt++;

                        if (outIt >= iteraciones * this.pParada) {
                            tiempoFin = new Date().getTime();
                            // System.out.println("¡Fin por optimalidad!\n");
                            return this.solucion;
                        }

                        continue;
                    }

                    dEnergia = estadoEnergia(this.alterado, this.envio.getFechaRegistro()) - estadoEnergia(this.solucion, this.envio.getFechaRegistro());

                    if (dEnergia >= 0) {

                        outIt++;
                        b = boltzmann(dEnergia, temperatura);
                        p = rnd.nextDouble();

                        if (p <= b) {
                            this.solucion = this.alterado;
                            //System.out.println("¡Alteración elegida por Boltzmann!");
                        }
                    } else {
                        outIt = 0;
                        this.solucion = this.alterado;
                        //System.out.println("¡Alteración elegida por mejora!");
                    }

                    if (outIt >= iteraciones * this.pParada) {
                        tiempoFin = new Date().getTime();
                        // System.out.println("¡Fin por optimalidad!\n");
                        return solucion;
                    }

                }

                this.enfriamiento();
            }

            tiempoFin = new Date().getTime();
            return solucion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
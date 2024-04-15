package ar.edu.unju.fi.ejercicio8.model;

public class CalculadoraEspecial {
    private int n;

    public CalculadoraEspecial() {
        this.n = 0;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double calcularSumatoria() {
        double sumatoria = 0;
        for (int k = 1; k <= n; k++) {
            sumatoria += (k * (k + 1.0) / 2.0) * (k * (k + 1.0) / 2.0);
        }
        return sumatoria;
    }
    
    public double calcularProductoria() {
    	double productoria = 1;
    	for (int k = 1; k <= n; k++) {
    		productoria *= (k * (k + 4.0));
    	}
    	return productoria;
    }
}


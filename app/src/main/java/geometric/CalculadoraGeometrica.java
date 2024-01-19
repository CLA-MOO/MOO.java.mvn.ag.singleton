package geometric;

public abstract class CalculadoraGeometrica {

	public double calcularArea(double a, double b) {
        Figura f = createFigura(a, b);
        return f.getArea();
	}

	public double calcularPerimetro(double a, double b) {
        Figura f = createFigura(a, b);
        return f.getPerimetro();
    }
    
    protected abstract Figura createFigura(double a, double b);
}

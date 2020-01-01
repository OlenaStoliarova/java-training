package ua.training.learning_gof_patterns.structural.adapter;

public class AdapterApp {
    public static void main(String[] args) {
        //1й способ - через наследование
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        //2й способ - через композицию
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2(new RasterGraphics());
        g2.drawLine();
        g2.drawSquare();
    }
}

interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}

class RasterGraphics{
    void drawRasterLine(){
        System.out.println("Рисуем линию");
    }
    void drawRasterSquare(){
        System.out.println("Рисуем квадрат");
    }
}

//класс для приведения методов существующего класса RasterGraphics к сигнатурам, требуемым в VectorGraphicsInterface
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
    private RasterGraphics raster;

    public VectorAdapterFromRaster2(RasterGraphics raster) {
        this.raster = raster;
    }

    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}


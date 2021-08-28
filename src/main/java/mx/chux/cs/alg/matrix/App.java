package mx.chux.cs.alg.matrix;

import java.util.logging.Logger;

public class App {
    
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    
    public static void main( String[] args ) {
        
        final Integer[][] data = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
            };
        
        LOGGER.info("Matrix rotations");
        
        Matrix<Integer> matrix = new Matrix<>(data);
        
        matrix.print();
        
        matrix.rotate(Matrix.Rotation.RIGHT).print();
        
        matrix.rotate(Matrix.Rotation.LEFT).print();
        
        matrix.rotate(Matrix.Rotation.RIGHT, 4).print();
        
        matrix.rotate(Matrix.Rotation.LEFT, 4).print();
    }
    
}

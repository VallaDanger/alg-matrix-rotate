package mx.chux.cs.alg.matrix;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class MatrixTest {

    Matrix<Integer> matrix;
    
    @Before
    public void initializeMatrix() {
        final Integer[][] data = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
            };
        this.matrix = new Matrix<Integer>(data);
    }
    
    @Test
    public void matrixShouldBeTheSameAfterLeftAndRightRotationsTest() {
        
        final String original = this.matrix.toString();
        
        this.matrix = this.matrix.rotateLeft().rotateRight();
        
        final String afterBothRotations = this.matrix.toString();
        
        assertThat(afterBothRotations).isEqualTo(original);
    }
    
    @Test
    public void matrixShouldBeTheSameAfterRightAndLeftRotationsTest() {
        
        final String original = this.matrix.toString();
        
        this.matrix = this.matrix.rotateRight().rotateLeft();
        
        final String afterBothRotations = this.matrix.toString();
        
        assertThat(afterBothRotations).isEqualTo(original);
    }
    
    private Matrix<Integer> rotateFourTimes(final Matrix.Rotation rotation) {
        return this.matrix.rotate(rotation, 4);
    }
    
    @Test
    public void matrixShouldBeTheSameAfterFourRightRotationsTest() {
        
        final String original = this.matrix.toString();
        
        this.matrix = rotateFourTimes(Matrix.Rotation.RIGHT);
        
        final String afterFourRightRotations = this.matrix.toString();
        
        assertThat(afterFourRightRotations).isEqualTo(original);
    }
    
    @Test
    public void matrixShouldBeTheSameAfterFourLeftRotationsTest() {
        
        final String original = this.matrix.toString();
        
        this.matrix = rotateFourTimes(Matrix.Rotation.LEFT);
        
        final String afterFourLeftRotations = this.matrix.toString();
        
        assertThat(afterFourLeftRotations).isEqualTo(original);
    }
    
}

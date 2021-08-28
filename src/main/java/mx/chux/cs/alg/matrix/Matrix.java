package mx.chux.cs.alg.matrix;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class Matrix<E> implements Supplier<E[][]> {
    
    private static final Logger LOGGER = Logger.getLogger(Matrix.class.getName());
    
    private final E[][] data;
    
    public Matrix(E[][] data) {
        this.data = data;
    }
    
    public enum Rotation { LEFT, RIGHT }
    
    public Matrix<E> rotateRight() {
        
        final int n = this.data.length - 1;
        
        for( int i = 0 ; i < (n/2) ; i++) {
            
            // furthest row/col to visit
            int k = n - i;
            
            for( int j = i ; j < k ; j++ ) {
                
                // save top-left
                // moves only along X axis ( towards right ) as j increments
                // index i keeps the row fixed to top
                final E temp = this.data[i][j];
                
                // top-left = bottom-left
                // moves only along Y axis ( towards top ) as j increments
                // index i modulates motion in Y axis
                // index i keeps the column fixed to first
                this.data[i][j] = this.data[k-j+i][i];
                
                // bottom-left = bottom-right
                // moves only along X axis ( towards left ) as j increments
                // index i modulates motion in X axis
                // index k keeps the row fixed to bottom
                this.data[k-j+i][i] = this.data[k][k-j+i];
                
                // bottom-right = top-right
                // moves only along Y axis ( towards bottom ) as j increments
                // index k keeps the column fixed to last
                this.data[k][k-j+i] = this.data[j][k];
                
                // top-right = top-left
                this.data[j][k] = temp;
                
            }
        }
        
        return this;
    }
    
    public Matrix<E> rotateLeft() {
        
        final int n = this.data.length - 1;
        
        for( int i = 0 ; i < (n/2) ; i++) {
            
            // furthest row/col to visit
            int k = n - i;
            
            for( int j = i ; j < k ; j++ ) {
                
                // save top-left
                final E temp = this.data[i][j];
                
                // top-left = top-right
                this.data[i][j] = this.data[j][k];
                
                // top-right = bottom-right
                this.data[j][k] = this.data[k][k-j+i];
                
                // bottom-right = bottom-left
                this.data[k][k-j+i] = this.data[k-j+i][i];
                
                // bottom-left = top-left
                this.data[k-j+i][i] = temp;
                
            }
        }
        
        return this;
    }
    
    public Matrix<E> rotateLeft(int times) {
        
        while( --times >= 0 ) {
            rotateLeft();
        }
        
        return this;
    }
    
    public Matrix<E> rotateRight(int times) {
        
        while( --times >= 0 ) {
            rotateRight();
        }
        
        return this;
    }
    
    public Matrix<E> rotate(final Rotation rotation, int times) {
        
        switch (rotation) {
        case LEFT:
            this.rotateLeft(times);
            break;

        case RIGHT:
        default:
            this.rotateRight(times);
            break;
        }
        
        return this;
    }
    
    public Matrix<E> rotate(final Rotation rotation) {
        return rotate(rotation, 1);
    }
    
    public void print() {
        
        final StringBuilder builder = new StringBuilder();
        
        builder.append("\n{\n");
        for( int i = 0 ; i < this.data.length ; i++ ) {
            builder.append(" { ");
            for( int j = 0 ; j < this.data[i].length ; j++ ) {
                if( j > 0 ) {
                    builder.append(", ");
                }
                builder.append(data[i][j]);
            }
            builder.append(" }\n");
        }
        builder.append("}");
        
        final String matrixStringRepresentation = builder.toString();
        LOGGER.info(matrixStringRepresentation);
    }

    @Override
    public E[][] get() {
        return this.data;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for( int i = 0 ; i < this.data.length ; i++ ) {
            for( int j = 0 ; j < this.data[i].length ; j++ ) {
                builder.append(this.data[i][j]);
            }
        }
        return builder.toString();
    }

}

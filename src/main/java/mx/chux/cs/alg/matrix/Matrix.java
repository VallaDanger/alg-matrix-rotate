package mx.chux.cs.alg.matrix;

import java.util.function.Supplier;

public class Matrix<E> implements Supplier<E[][]> {
    
    private final E[][] matrix;
    
    public Matrix(E[][] data) {
        this.matrix = data;
    }
    
    public enum Rotation { LEFT, RIGHT }
    
    public Matrix<E> rotateRight() {
        
        final int n = this.matrix.length - 1;
        
        for( int i = 0 ; i < (n/2) ; i++) {
            
            // furthest row/col to visit
            int k = n - i;
            
            for( int j = i ; j < k ; j++ ) {
                
                // save top-left
                final E temp = this.matrix[i][j];
                
                // top-left = bottom-left
                this.matrix[i][j] = this.matrix[k-j+i][i];
                
                // bottom-left = bottom-right
                this.matrix[k-j+i][i] = this.matrix[k][k-j+i];
                
                // bottom-right = top-right
                this.matrix[k][k-j+i] = this.matrix[j][k];
                
                // top-right = top-left
                this.matrix[j][k] = temp;
                
            }
        }
        
        return this;
    }
    
    public Matrix<E> rotateLeft() {
        
        final int n = this.matrix.length - 1;
        
        for( int i = 0 ; i < (n/2) ; i++) {
            
            // furthest row/col to visit
            int k = n - i;
            
            for( int j = i ; j < k ; j++ ) {
                
                // save top-left
                final E temp = this.matrix[i][j];
                
                // top-left = top-right
                this.matrix[i][j] = this.matrix[j][k];
                
                // top-right = bottom-right
                this.matrix[j][k] = this.matrix[k][k-j+i];
                
                // bottom-right = bottom-left
                this.matrix[k][k-j+i] = this.matrix[k-j+i][i];
                
                // bottom-left = top-left
                this.matrix[k-j+i][i] = temp;
                
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
        
        System.out.println("{");
        for( int i = 0 ; i < this.matrix.length ; i++ ) {
            System.out.print(" { ");
            for( int j = 0 ; j < this.matrix[i].length ; j++ ) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("}");
        }
        System.out.println("}");
        
    }

    @Override
    public E[][] get() {
        return this.matrix;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for( int i = 0 ; i < this.matrix.length ; i++ ) {
            for( int j = 0 ; j < this.matrix[i].length ; j++ ) {
                builder.append(this.matrix[i][j]);
            }
        }
        return builder.toString();
    }

}

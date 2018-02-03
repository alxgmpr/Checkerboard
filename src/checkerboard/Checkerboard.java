/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 *
 * @author alex
 */     
public class Checkerboard {
    private int numRows;
    private int numCols;
    
    private double boardWidth;
    private double boardHeight;

    private Color lightColor;
    private Color darkColor;
    
    private AnchorPane anchorPane;
    
    /* This constructor has option to set colors */
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this.numRows = numRows;
        this.numCols = numCols;
        
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    /* This default constructor assumes red/black for colors */
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    /* Getter functions */
    public AnchorPane getBoard() {
        if (this.anchorPane == null) {
            this.anchorPane = this.build();
            return this.anchorPane;
        } else {
            return this.anchorPane;
        }
    }
    
    public int getNumRows() {
        return this.numRows;
    }
    
    public int getNumCols() {
        return this.numCols;
    }
    
    public double getWidth() {
        return this.boardWidth;
    }
    
    public double getHeight() {
        return this.boardHeight;
    }
    
    public Color getLightColor() {
        return this.lightColor;
    }
    
    public Color getDarkColor() {
        return this.darkColor;
    }
    
    public double getRectangleWidth() {
        return Math.ceil(this.boardWidth / this.numCols);
    }
    
    public double getRectangleHeight() {
        return Math.ceil(this.boardHeight / this.numRows);
    }
    
    /* Setter functions */
    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
    
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }
    
    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }
    
    public void setBoardWidth(double boardWidth) {
        this.boardWidth = boardWidth;
    }
    
    public void setBoardHeight(double boardHeight) {
        this.boardHeight = boardHeight;
    }
    
    public void setLightColor(Color lightColor) {
        this.lightColor = lightColor;
    }
    
    public void setDarkColor(Color darkColor) {
        this.darkColor = darkColor;
    }
    
    public void clear() {
        if (this.anchorPane != null) {
            this.anchorPane.getChildren().clear();
        }
    }
    
    
    /* Build functionality */
    public AnchorPane build() {
        this.clear();
        
        for (int i = 0; i < this.numRows; i++) {
            
            for (int j = 0; j < this.numCols; j++) {
                
                Rectangle rectangle;
                
                if ( ((i+j) % 2) == 0) {
                    rectangle = new Rectangle(getRectangleWidth(), getRectangleHeight(), this.lightColor);
                } else {
                    rectangle = new Rectangle(getRectangleWidth(), getRectangleHeight(), this.darkColor);
                }
                
                
                this.anchorPane.getChildren().add(rectangle);
                
                rectangle.setTranslateX(getRectangleWidth() * i);
                rectangle.setTranslateY(getRectangleHeight() * j);
                
                
            }
            
        }
        
        return this.anchorPane;
    }
}

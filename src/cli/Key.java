package cli;

public class Key {
	private final int x;
    private final int y;
    private Float f;
    private int realCol;

    protected Key(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    protected Float getValue() {
    	return this.f;
    }
    
    protected int getRow() {
    	return this.x;
    }
    
    protected int getColumn() {
    	return this.y;
    }
    
    protected Key setValue(Float f) {
    	this.f = f;
    	return this;
    }
    
    protected Key setRealCol(int realCol) {
    	this.realCol = realCol;
    	return this;
    }
    
    protected int getRealCol() {
    	return this.realCol;
    }
    

}

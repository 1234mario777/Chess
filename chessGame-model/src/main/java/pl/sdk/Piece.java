package pl.sdk;

public class Piece {

    private final PieceProperties properties;

    public Piece(){
        properties = new PieceProperties("DefName");
    }

    public String getName(){
        return properties.getName();
    }
}
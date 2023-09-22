package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Ticket {
    private STATUS status;
    private Integer row;
    private Integer column;
    private Integer price;
    private Token token;


    enum STATUS {AVAILABLE, TAKEN}

    public Ticket() {}


    public Ticket(Integer row, Integer column) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
        this.status = STATUS.AVAILABLE;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }

    public Integer getPrice() {
        return price;
    }

    @JsonIgnore
    public STATUS getStatus() {
        return this.status;
    }

    @JsonIgnore
    public Token getToken() {return this.token;}
    public boolean hasToken() {return token != null;}
    public void setToken(Token token) {this.token = token;}
    public void setTaken() {
        this.status = STATUS.TAKEN;
    }
    public void setAvailable() {this.status = STATUS.AVAILABLE;}



}

package model;

public class Friend {
    int idReceiver;
    int idSender;
    String status;

    public Friend() {
    }

    public Friend(int idReceiver, int idSender, String status) {
        this.idReceiver = idReceiver;
        this.idSender = idSender;
        this.status = status;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package vk.kirisaki.models;

import java.util.List;

public class Subsciber extends User {
    private List<Object> borrows;
    private List<Object> render;

    public Subsciber(String name, String reference, Sex sex) {
        super(name, reference, sex);
    }

    public List<Object> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Object> borrows) {
        this.borrows = borrows;
    }

    public List<Object> getRender() {
        return render;
    }

    public void setRender(List<Object> render) {
        this.render = render;
    }
}

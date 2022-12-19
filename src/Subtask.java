import java.util.Objects;

public class Subtask extends Task {
    protected int idOfTask;

    public Subtask(int id, String name, String description, String status, int idOfTask) {
        super(id, name, description, status);
        this.idOfTask = idOfTask;
    }

    public void setIdOfTask(int idOfTask) {
        this.idOfTask = idOfTask;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", idOfTask=" + idOfTask +
                '}';
    }

    public int getIdOfTask() {
        return idOfTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Subtask subtask = (Subtask) o;
        return idOfTask == subtask.idOfTask;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idOfTask);
    }
}



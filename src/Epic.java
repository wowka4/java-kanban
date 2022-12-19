import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task {
    protected ArrayList<Integer> idsSubtasks = new ArrayList<>();

    public Epic(int id, String name, String description, String status) {
        super(id, name, description, status);
    }

    public ArrayList<Integer> getIdsSubtasks() {
        return idsSubtasks;
    }

    public void setIdsSubtasks(ArrayList<Integer> idsSubtasks) {
        this.idsSubtasks = idsSubtasks;
    }

    public void addIdOfSubtask(int id) {
        idsSubtasks.add(id);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", idsSubtasks=" + idsSubtasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(idsSubtasks, epic.idsSubtasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idsSubtasks);
    }
}

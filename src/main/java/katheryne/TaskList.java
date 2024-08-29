package katheryne;

import java.util.ArrayList;


/**
 * TaskList is used to store and manage tasks
 */
public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public TaskList(TaskList l) {
        this.taskList = l.getTaskList();
    }

    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    public void mark(int id) {
        Task t = taskList.get(id);
        t.mark();
    }

    public void unmark(int id) {
        Task t = taskList.get(id);
        t.unmark();
    }

    public void addTask(Task t) {
        taskList.add(t);
    }

    public void deleteTask(int id) {
        taskList.remove(id);
    }

    public Task getTask(int id) {
        return taskList.get(id);
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < taskList.size(); i++) {
            int index = i+1;
            String item = index + ". " + taskList.get(i).toString() + '\n';
            output = output + item;
        }
        return output;
    }
}

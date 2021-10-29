package ToDo;

class Task {

    // I did not use OOP for this exercise, so this file is redundant
    //However, it's a nice practice anyway, so I kept it

    private String taskUser;
    private String task;
    private enum Status {
        OPEN,
        DONE
    }
    private Status status;

    public String getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(String taskUser) {
        this.taskUser = taskUser;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Task(String taskUser, String task, char status) {

        this.taskUser = taskUser;
        this.task = task;
        switch (Character.toLowerCase(status)) {
            case 'o':
                this.status = Task.Status.OPEN;
                break;
            case 'd':
                this.status = Task.Status.DONE;
                break;
        }

    }
}

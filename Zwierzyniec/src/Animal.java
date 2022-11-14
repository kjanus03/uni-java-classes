public abstract class Animal {
    private float age;
    private String race;
    private boolean isDangerous;
    private boolean has_tail;

    public float getAge() {
        return age;
    }

    public String getRace() {
        return race;
    }

    public boolean getDangerous() {
        return isDangerous;
    }

    public boolean getTail() {
        return has_tail;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setDangerous(boolean isDangerous) {
        this.isDangerous = isDangerous;
    }

    public void setTail(boolean has_tail) {
        this.has_tail = has_tail;
    }
    public String toString(){
        String result = "I am an animal.\nI am " + age + " years old.";
        return result;
    }
}

package by.prohorov.subject;

public class Note extends Entity {
    private String nameNote;
    private String textNote;

    public Note(String nameNote, String textNote) {
        this.nameNote = nameNote;
        this.textNote = textNote;
    }

    public Note(int id, String nameNote, String textNote) {
        super(id);
        this.nameNote = nameNote;
        this.textNote = textNote;
    }

    public String getNameNote() {
        return nameNote;
    }

    public void setNameNote(String nameNote) {
        this.nameNote = nameNote;
    }

    public String getTextNote() {
        return textNote;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

}

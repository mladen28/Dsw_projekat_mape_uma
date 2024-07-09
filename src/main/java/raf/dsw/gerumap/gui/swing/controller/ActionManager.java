package raf.dsw.gerumap.gui.swing.controller;

public class ActionManager {

    private NewAction newAction;
    private InfoAction infoAction;
    private DeleteAction deleteAction;
    private EditAction editAction;
    private DeleteStateAction deleteStateAction;
    private ChooseCollorAction chooseCollorAction;
    private LinkStateAction linkStateAction;
    private SelectedStateAction selectedStateAction;
    private TermStateAction termStateAction;
    private MoveStateAction moveStateAction;
    private ZoomStateAction zoomStateAction;
    private RedoCommandAction redoCommandAction;
    private UndoCommandAction undoCommandAction;
    private SaveProjectAction saveProjectAction;
    private OpenProjectAction openProjectAction;
    private ExportAction exportAction;

    public ActionManager () {

        initialiseActions();
    }

    private void initialiseActions() {

        newAction = new NewAction();
        infoAction = new InfoAction();
        deleteAction = new DeleteAction();
        editAction = new EditAction();
        deleteStateAction = new DeleteStateAction();
        chooseCollorAction = new ChooseCollorAction();
        linkStateAction = new LinkStateAction();
        selectedStateAction = new SelectedStateAction();
        termStateAction = new TermStateAction();
        moveStateAction = new MoveStateAction();
        zoomStateAction = new ZoomStateAction();
        redoCommandAction = new RedoCommandAction();
        undoCommandAction = new UndoCommandAction();
        saveProjectAction = new SaveProjectAction();
        openProjectAction = new OpenProjectAction();
        exportAction = new ExportAction();

    }

    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        this.deleteAction = deleteAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public void setEditAction(EditAction editAction) {
        this.editAction = editAction;
    }

    public DeleteStateAction getDeleteStateAction() {
        return deleteStateAction;
    }

    public void setDeleteStateAction(DeleteStateAction deleteStateAction) {
        this.deleteStateAction = deleteStateAction;
    }

    public ChooseCollorAction getChooseCollorAction() {
        return chooseCollorAction;
    }

    public void setChooseCollorAction(ChooseCollorAction chooseCollorAction) {
        this.chooseCollorAction = chooseCollorAction;
    }

    public LinkStateAction getLinkStateAction() {
        return linkStateAction;
    }

    public void setLinkStateAction(LinkStateAction linkStateAction) {
        this.linkStateAction = linkStateAction;
    }

    public SelectedStateAction getSelectedStateAction() {
        return selectedStateAction;
    }

    public void setSelectedStateAction(SelectedStateAction selectedStateAction) {
        this.selectedStateAction = selectedStateAction;
    }

    public TermStateAction getTermStateAction() {
        return termStateAction;
    }

    public void setTermStateAction(TermStateAction termStateAction) {
        this.termStateAction = termStateAction;
    }

    public MoveStateAction getMoveStateAction() {
        return moveStateAction;
    }

    public void setMoveStateAction(MoveStateAction moveStateAction) {
        this.moveStateAction = moveStateAction;
    }

    public ZoomStateAction getZoomStateAction() {return zoomStateAction;}

    public void setZoomStateAction(ZoomStateAction zoomStateAction) {this.zoomStateAction = zoomStateAction;}

    public RedoCommandAction getRedoCommandAction() {
        return redoCommandAction;
    }

    public void setRedoCommandAction(RedoCommandAction redoCommandAction) {
        this.redoCommandAction = redoCommandAction;
    }

    public UndoCommandAction getUndoCommandAction() {
        return undoCommandAction;
    }

    public void setUndoCommandAction(UndoCommandAction undoCommandAction) {
        this.undoCommandAction = undoCommandAction;
    }

    public SaveProjectAction getSaveProjectAction() {
        return saveProjectAction;
    }

    public void setSaveProjectAction(SaveProjectAction saveProjectAction) {
        this.saveProjectAction = saveProjectAction;
    }

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public void setOpenProjectAction(OpenProjectAction openProjectAction) {
        this.openProjectAction = openProjectAction;
    }

    public ExportAction getExportAction() {
        return exportAction;
    }

    public void setExportAction(ExportAction exportAction) {
        this.exportAction = exportAction;
    }
}
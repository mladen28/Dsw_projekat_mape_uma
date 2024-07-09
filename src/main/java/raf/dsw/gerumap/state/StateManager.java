package raf.dsw.gerumap.state;

public class StateManager {

    private State currState;
    private TermState termState;
    private SelectState selectState;
    private MoveState moveState;
    private DeleteState deleteState;
    private LinkState linkState;
    private ZoomState zoomState;

    public StateManager(){ initStates();}

    private void initStates() {
        termState = new TermState();
        selectState = new SelectState();
        moveState = new MoveState();
        deleteState = new DeleteState();
        linkState = new LinkState();
        zoomState = new ZoomState();
        currState = termState;
    }

    public State getCurrState() {
        return currState;
    }

    public void setTermState() {
        currState = termState;
    }

    public void setDeleteState() {
        currState = deleteState;
    }

    public void setMoveState() {
        currState = moveState;
    }

    public void setSelectState() {
        currState = selectState;
    }

    public void setLinkState() {
        currState = linkState;
    }

    public void setZoomState() {currState = zoomState;}
}

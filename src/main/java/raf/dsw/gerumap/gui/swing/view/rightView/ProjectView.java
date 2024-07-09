package raf.dsw.gerumap.gui.swing.view.rightView;

import raf.dsw.gerumap.ErrorFactory.Errors;
import raf.dsw.gerumap.ErrorFactory.MessageGeneratorImplementation;
import raf.dsw.gerumap.Observer.Subscriber;
import raf.dsw.gerumap.gui.swing.controller.MouseController;
import raf.dsw.gerumap.gui.swing.view.ElementToolBar;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.Link;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.Term;
import raf.dsw.gerumap.state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ProjectView extends JPanel implements Subscriber {

    private Project project;
    public static List<ProjectView> projectViews = new ArrayList<>();

    private JLabel lblProjectName;
    private JTabbedPane tabbedPane;
    private JLabel lbAutor;
    private JPanel bigPanel;
    private JPanel panel;
    private MindMapView currMindMap;
    private Point point;
    private MindMap mindMapCurrent;
    private Term term;
    private Link link;
    private List<MindMapView> mindMapViews;
    private StateManager stateManager;
    private ElementToolBar elementToolBar;


    public ProjectView(Project p) {
        this.project = p;
        this.mindMapViews = new ArrayList<>();

        stateManager = new StateManager();
        point = new Point();
        currMindMap = new MindMapView(new MindMap("MindMap", p));
        p.addSubscriber(this);
        init();

    }

    private void init() {

        setLayout(new BorderLayout());
        setSize(new Dimension(100,100));

        GridLayout grid = new GridLayout(2, 0);
        grid.setVgap(5);

        JPanel projectPanel = new JPanel(grid);
        lblProjectName = new JLabel(this.project.getName());

        lbAutor = new JLabel();
        if(project.getImeAutora() != null) {
            lbAutor.setText(project.getImeAutora());
        }

        projectPanel.add(lblProjectName);
        projectPanel.add(lbAutor);


        this.add(projectPanel, BorderLayout.NORTH);



        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        this.add(tabbedPane, BorderLayout.CENTER);

        elementToolBar = new ElementToolBar();
        this.add(elementToolBar, BorderLayout.EAST);

    }

    private boolean addNewMindMapView(String mindMapModelName) {
        for(MapNode mindMap : this.project.getChildren()){
            if(mindMap.getName().equals(mindMapModelName)){
                MindMapView mindMapView = new MindMapView((MindMap) mindMap);
                this.mindMapViews.add(mindMapView);
                this.tabbedPane.addTab(mindMapView.getMindMap().getName(), mindMapView);
                this.validate();
                this.repaint();
                return true;
            }
        }
        return false;
    }

    public boolean removeMindMapView(String MindMapModelName) {
        for (MindMapView mindMap : mindMapViews) {
            System.out.println(MindMapModelName);
            if (mindMap.getMindMap().getName().equals(MindMapModelName)) {
                this.tabbedPane.remove(this.mindMapViews.indexOf(mindMap));
                this.mindMapViews.remove(mindMap);

                this.revalidate();
                this.repaint();
                return true;
            }
        }

        return false;
    }

    public void setMindMapView(int idx) {
        this.tabbedPane.setSelectedIndex(idx);
    }

    public void addTermState() {
        stateManager.setTermState();
        System.out.println("Add state");
    }
    public void addLinkState(){
        stateManager.setLinkState();
        System.out.println("addLinkState");
    }

    public void deleteTermState() {
        stateManager.setDeleteState();
        System.out.println("Delete state");
    }

    public void selectedState(){
        stateManager.setSelectState();
        System.out.println("SelectedState");
    }

    public void moveState()
    {
        stateManager.setMoveState();
        System.out.println("Move State");
    }
    public void zoomState(){
        stateManager.setZoomState();
        System.out.println("Zoom State");
    }
    @Override
    public void update(Object notification) {

        if(notification instanceof String) {

            String message = (String) notification;

            if (message.contains("add")) {
                if (!addNewMindMapView(message.split(" ")[1] + " " + message.split(" ")[2])) {
                    MessageGeneratorImplementation.getInstance().generateError(Errors.noExistingProject);
                }

            } else if (message.contains("rename")) {
                String[] splitMessage = message.split(" ");
                String name = "";
                for (int i = 1; i < splitMessage.length; i++) {
                    name += splitMessage[i];
                    name += " ";
                }
                this.lblProjectName.setText(name);

            } else if (message.contains("delete")) {
                if (!removeMindMapView(message.split(" ")[1] + " " + message.split(" ")[2])) {
                    MessageGeneratorImplementation.getInstance().generateError(Errors.noExistingProject);
                }
            } else if (message.contains("autor")) {
                this.lbAutor.setText(this.project.getImeAutora());
            }
        } else if (notification instanceof MapNode) {
            project.addSubscriber(this);
        }
    }

    public void misKliknut(){
        stateManager.getCurrState().misKliknut(currMindMap, point.x, point.y);
    }
    public void misPovucen(MindMapView MindMapView, Point point)
    {
        this.stateManager.getCurrState().misPovucen(MindMapView, point.x, point.y);
    }
    public void misPusten()
    {
        this.stateManager.getCurrState().misPusten(currMindMap, point.x, point.y);
    }


        public int getStroke () {
           if(elementToolBar.getStrokeSize().getText().isEmpty()){
                return 1;
            }
            return (parseInt(elementToolBar.getStrokeSize().getText()));

    }

    public MindMap getMindMapCurrent() {
        return ((MindMapView) tabbedPane.getSelectedComponent()).getMindMap();
    }

    public void setMindMapCurrent(MindMap mindMapCurrent) {
        this.mindMapCurrent = mindMapCurrent;
    }

    public JLabel getLblProjectName () {
            return lblProjectName;
        }

        public void setLblProjectName (JLabel lblProjectName){
            this.lblProjectName = lblProjectName;
        }

        public JTabbedPane getTabbedPane () {
            return tabbedPane;
        }

        public void setTabbedPane (JTabbedPane tabbedPane){
            this.tabbedPane = tabbedPane;
        }

        public Project getProject () {
            return project;
        }

        public void setProject (Project project){
            this.project = project;
        }

        public static List<ProjectView> getProjectViews () {
            return projectViews;
        }

        public static void setProjectViews (List < ProjectView > projectViews) {
            ProjectView.projectViews = projectViews;
        }

        public List<MindMapView> getMindMapViews () {
            return mindMapViews;
        }

        public void setMindMapViews (List < MindMapView > mindMapViews) {
            this.mindMapViews = mindMapViews;
        }

        public JLabel getLbAutor () {
            return lbAutor;
        }

        public void setLbAutor (JLabel lbAutor){
            this.lbAutor = lbAutor;
        }

        public JPanel getBigPanel () {
            return bigPanel;
        }

        public void setBigPanel (JPanel bigPanel){
           this.bigPanel = bigPanel;
        }

        public JPanel getPanel () {
            return panel;
        }

        public void setPanel (JPanel panel){
            this.panel = panel;
        }

        public MindMapView getCurrMindMap () {
            return currMindMap;
        }

        public void setCurrMindMap (MindMapView currMindMap){
            this.currMindMap = currMindMap;
        }

        public Point getPoint () {
            return point;
        }

        public void setPoint (Point point){
            this.point = point;
        }

       /* public Color getColor () {
            return color;
        }

        public void setColor (Color color){
            this.color = color;
        }

        */


        public StateManager getStateManager () {
            return stateManager;
        }

        public void setStateManager (StateManager stateManager){
            this.stateManager = stateManager;
        }

        public ElementToolBar getElementToolBar () {
            return elementToolBar;
        }

        public void setElementToolBar (ElementToolBar elementToolBar){
            this.elementToolBar = elementToolBar;
        }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}


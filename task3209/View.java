package com.javarush.task.task32.task3209;


import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }
    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }
    public void exit(){
        controller.exit();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,menuBar);
        MenuHelper.initEditMenu(this,menuBar);
        MenuHelper.initStyleMenu(this,menuBar);
        MenuHelper.initAlignMenu(this,menuBar);
        MenuHelper.initColorMenu(this,menuBar);
        MenuHelper.initFontMenu(this,menuBar);
        MenuHelper.initHelpMenu(this,menuBar);
        getContentPane().add(menuBar,BorderLayout.NORTH);

    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML",jScrollPane);
        JScrollPane scrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст",scrollPane);
        tabbedPane.setPreferredSize(new Dimension(480,640));
        TabbedPaneChangeListener changeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(changeListener);
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();

    }
    public boolean canUndo(){
        return undoManager.canUndo();
    }
    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public void selectedTabChanged(){
        if (tabbedPane.getSelectedIndex() == 0){
            controller.setPlainText(plainTextPane.getText());
        }
        else {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }
    public void undo(){
        try {
            undoManager.undo();
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try{
            undoManager.redo();
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected(){
        if (tabbedPane.getSelectedIndex() == 0) return true;
        else return false;
    }
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());

    }
    public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(), "Version 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
    }

}

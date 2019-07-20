package jp.co.project_dev.personalwiki;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JComponent;
import javax.swing.JEditorPane;
//import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTree;

import jp.co.project.dev.common.swing.DEVFrame;

public class MainFrm extends DEVFrame {

	private JTree wikiTree = null;
	private JTextArea taEditor = null;
	private JComponent pnlHtmlViewer = null;
	
	/** */
	private static final long serialVersionUID = 1L;

	public MainFrm() throws HeadlessException {
		super("Personal Wiki");
	}

	@Override
	protected void onCreate() {
		setLayout(new BorderLayout());

		JSplitPane pnlMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JTabbedPane pnlLeft = new JTabbedPane();
		JTabbedPane pnlRight = new JTabbedPane();
		createLeftPane(pnlLeft);
		createRightPane(pnlRight);
		pnlMain.add(pnlLeft);
		pnlMain.add(pnlRight);
		setMainPanel(pnlMain);
		
	}
	
	private void createLeftPane(JTabbedPane pnl){
		wikiTree = new JTree();
		JScrollPane scPanel = new JScrollPane(wikiTree);
		pnl.add("Wiki", scPanel);
	}

	private void createRightPane(JTabbedPane pnl){
		taEditor = new JTextArea();
		JScrollPane scPanel = new JScrollPane(taEditor);
		pnlHtmlViewer = null;
		if(pnlHtmlViewer == null){
			pnlHtmlViewer = getDefaultHTMLViewer();
		}
		pnl.add("Html", pnlHtmlViewer);
		pnl.add("Editor", scPanel);
	}

	/**
	 * デフォルトのHTMLビューアを取得します。
	 * @return
	 */
	private JComponent getDefaultHTMLViewer(){
		JEditorPane pnlHtml = new JEditorPane();
		pnlHtml.setContentType("text/html");
		pnlHtml.setEditable(false);
		JScrollPane scPanel = new JScrollPane(pnlHtml);
		return scPanel;
	}

}

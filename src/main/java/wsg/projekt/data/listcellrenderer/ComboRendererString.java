package wsg.projekt.data.listcellrenderer;

import java.awt.Color;
import java.awt.Component;
import java.util.function.Supplier;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.UIManager;

import wsg.projekt.data.util.HtmlHighlighter;

public class ComboRendererString extends DefaultListCellRenderer{
	
	private static final long serialVersionUID = 1L;
	public static final Color background = new Color(225, 240, 255);
    private static final Color defaultBackground = (Color) UIManager.get("List.background");
    private static final Color defaultForeground = (Color) UIManager.get("List.foreground");
    private Supplier<String> highlightTextSupplier;
    
    public ComboRendererString(Supplier<String> highlightTextSupplier) {
        this.highlightTextSupplier = highlightTextSupplier;
    }
    
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value.equals(null)) {
            return this;
        }
        String text = getCzasText((String) value);
        text = HtmlHighlighter.highlightText(text, highlightTextSupplier.get());
        this.setText(text);
        if (!isSelected) {
            this.setBackground(index % 2 == 0 ? background : defaultBackground);
        }
        this.setForeground(defaultForeground);
        return this;
	}
	
    public static String getCzasText(String tekst) {
        if (tekst == null) {
            return "";
        }
        return tekst;
    }
}

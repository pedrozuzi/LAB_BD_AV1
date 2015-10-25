package control;

import java.util.ArrayList;
import java.util.List;

import entity.Resultados;
import persistence.ResultadosDao;
import persistence.ResultadosDaoImpl;

public class CtrlResultados {

	public List<Resultados> resultadoGeral(){
		
	ResultadosDao rDao = new ResultadosDaoImpl();
		List<Resultados> lista = new ArrayList<Resultados>();
		lista = rDao.resultadosGeral();
		return lista;
	}
	
	public List<Resultados> quartasdeFinal(){
		
	ResultadosDao rDao = new ResultadosDaoImpl();
		List<Resultados> lista = new ArrayList<Resultados>();
		lista = rDao.quartasDeFinal(grupo);
		return lista;
	}
	
	public void rebaixados(){
		
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {  
		    public Component getTableCellRendererComponent(JTable table, Object value,  
		            boolean isSelected, boolean hasFocus, int row, int column) {  
		        super.getTableCellRendererComponent(table, value, isSelected,  
		                hasFocus, row, column);  
		        if (row == 1) {  
		            setBackground(Color.RED);  
		        } else {  
		            setBackground(null);  
		        }  
		        return this;  
		    }  
		});  
		
	}
	
}

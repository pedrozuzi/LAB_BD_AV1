package control;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

//import com.sun.prism.paint.Color;

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
	
	public List<Resultados> quartasdeFinal(String grupo){
		
	ResultadosDao rDao = new ResultadosDaoImpl();
		List<Resultados> lista = new ArrayList<Resultados>();
		lista = rDao.quartasDeFinal(grupo);
		return lista;
	}
	
	public JTable rebaixados(String grupo, JTable tabelaResultadoGeral){
		
		ResultadosDao rDao = new ResultadosDaoImpl();
		List<Resultados>  lista = new ArrayList<Resultados>();
	    lista = rDao.rebaixados(grupo);
	    final List<Resultados>  lista2 = lista;
		
		tabelaResultadoGeral.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {  
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value,  
		            boolean isSelected, boolean hasFocus, int row, int column) {  
		        super.getTableCellRendererComponent(table, value, isSelected,  
		                hasFocus, row, column);  
		        
		        System.out.println(tabelaResultadoGeral.getValueAt(0,0));
		        
		        if(row ==1){
		        	setBackground(Color.RED); 
		        }else{
		        	setBackground(null);  
		        }
		        
		        //for(int i=0;i<20;i++){

		        	
			   //     if (row == i && lista2.get(i).getNome_time().equals(tabelaResultadoGeral.getValueAt(i,0)) ) {  
			   //         setBackground(Color.RED);  
			   //     } else {  
			   //         setBackground(null);  
			  //      } 
		       // }
 
		        return this; 
		    }  
		});
		return tabelaResultadoGeral;  
		
		
		/*
		 *                 int column = e.getColumn();  
                int row = e.getFirstRow();  
                  
                if(column<0||row<0) return;  
                  
                System.out.println(jTable1.getValueAt(row, column));  
            }  
		 */
		
	}
	
}

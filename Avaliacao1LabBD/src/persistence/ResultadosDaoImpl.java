package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.GruposResultados;
import entity.QuartasdeFinal;
//import entity.Resultados;
import entity.Times;

public class ResultadosDaoImpl implements ResultadosDao {

	private Connection c;
	
	public ResultadosDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	
	@Override
	public List<GruposResultados> resultadosGrupos(String grupo) {
		List<GruposResultados> lista = new ArrayList<>(); 
		String query = "select * from dbo.grupo(?) ";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement( query );
			ps.setString(1, grupo );
			ResultSet rs = ps.executeQuery();
			
			
			while ( rs.next() ) {
				GruposResultados gr = new GruposResultados();
				Times t = new Times();
				t.setNome( rs.getString("nome_Time"));
				gr.setTime(t);
				gr.setJogos(rs.getInt("num_jogos_disputados"));
				gr.setVitorias(rs.getInt("vitorias"));
				gr.setEmpates(rs.getInt("empates"));
				gr.setDerrotas(rs.getInt("derrotas"));
				gr.setGolsMarcados(rs.getInt("gols_marcados"));
				gr.setGolsSofridos(rs.getInt("gols_sofridos"));
				gr.setSaldoGols(rs.getInt("saldo_gols"));
				gr.setPontos(rs.getInt("pontos"));
				lista.add(gr);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<GruposResultados> resultadosGeral() {
		List<GruposResultados> lista = new ArrayList<>(); 
		String query = "select * from dbo.fn_campeonato() order by pontos desc, vitorias desc, gols_marcados desc, saldo_gols desc";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement( query );
			ResultSet rs = ps.executeQuery();
			
			
			while ( rs.next() ) {
				GruposResultados gr = new GruposResultados();
				Times t = new Times();
				t.setNome( rs.getString("nome_Time"));
				gr.setTime(t);
				gr.setJogos(rs.getInt("num_jogos_disputados"));
				gr.setVitorias(rs.getInt("vitorias"));
				gr.setEmpates(rs.getInt("empates"));
				gr.setDerrotas(rs.getInt("derrotas"));
				gr.setGolsMarcados(rs.getInt("gols_marcados"));
				gr.setGolsSofridos(rs.getInt("gols_sofridos"));
				gr.setSaldoGols(rs.getInt("saldo_gols"));
				gr.setPontos(rs.getInt("pontos"));
				lista.add(gr);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<QuartasdeFinal> quartasDeFinal(String grupo) {
		List<QuartasdeFinal> lista = new ArrayList<>(); 
		String query = "select * from dbo.fn_quartas(?)";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement( query );
			ps.setString(1, grupo );
			ResultSet rs = ps.executeQuery();
			
			
			while( rs.next() ) {
				
				QuartasdeFinal qt = new QuartasdeFinal();

				qt.setTimeA(rs.getString("timeA"));
				qt.setTimeB(rs.getString("timeB"));

			lista.add(qt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<GruposResultados> rebaixados() {
		List<GruposResultados> lista = new ArrayList<>(); 
		String query = "select * from dbo.fn_rebaixados() ";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement( query );
			ResultSet rs = ps.executeQuery();
			
			
			while ( rs.next() ) {
				GruposResultados gr = new GruposResultados();
				Times t = new Times();
				t.setNome( rs.getString("nome_Time"));
				gr.setTime(t);
				gr.setJogos(rs.getInt("num_jogos_disputados"));
				gr.setVitorias(rs.getInt("vitorias"));
				gr.setEmpates(rs.getInt("empates"));
				gr.setDerrotas(rs.getInt("derrotas"));
				gr.setGolsMarcados(rs.getInt("gols_marcados"));
				gr.setGolsSofridos(rs.getInt("gols_sofridos"));
				gr.setSaldoGols(rs.getInt("saldo_gols"));
				gr.setPontos(rs.getInt("pontos"));
				lista.add(gr);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return lista;
	}

}

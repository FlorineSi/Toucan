package toucan.outils;
public class KitJava {
	
	String laClasse;
	
	public void construireCode(String chaine){
		StringBuilder sb = new StringBuilder("");
		sb.append("package toucan.modele;\n");
		sb.append("import toucan.graphique.AffectationCaseCase;\n");
		sb.append("import toucan.graphique.AffectationCaseVar;\n");
		sb.append("import toucan.graphique.AffectationVarCase;\n");
		sb.append("import toucan.graphique.ComparaisonCaseCase;\n");
		sb.append("public class AlgoPerso implements IAlgo{\n");
		sb.append("private LesCases lesCases;\n");
		sb.append("private AffectationCaseCase acc;\n");
		sb.append("private ComparaisonCaseCase ccc;\n");
		sb.append("private AffectationCaseVar acv;\n");
		sb.append("private AffectationVarCase avc;\n");
		sb.append("public AlgoPerso(LesCases lc){\n");
		sb.append("this.lesCases = lc;\n");
		sb.append("this.ccc = new ComparaisonCaseCase();\n");
		sb.append("this.acc = new AffectationCaseCase();\n");
		sb.append("this.acv = new AffectationCaseVar();\n");
		sb.append("this.avc = new AffectationVarCase();\n");
		sb.append("}\n");
		sb.append("public void trier(){\n");
		sb.append(chaine);
		sb.append("}\n");
		sb.append("public void setLesCases(LesCases lc) {\n");
		sb.append("this.lesCases = lc;\n");
		sb.append("}\n");
		sb.append("}");
		laClasse = sb.toString();
	}
	
	public void compiler(){
		
	}
	
	public void executer(){
		
	}
	
	public void main(String [] args){
		construireCode("");
		System.out.println(laClasse);
	}

}

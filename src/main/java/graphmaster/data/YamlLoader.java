package graphmaster.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlLoader {
	FileReader reader;
	Yaml yaml = new Yaml();

	public YamlLoader( String fileName ) throws FileNotFoundException {
		reader = new FileReader( fileName );
	}
	
	public void close() throws IOException {
		reader.close();
	}
	
	public Map<?,?> load() {
		return (Map<?,?>)yaml.load(reader);
	}

	public static Vector2 toVector2( Object o ) {
		Vector2 v = new Vector2();
		double[] a = toDoubleArray(2, o);
		v.x = a[0];
		v.y = a[1];
		return v;
	}

	public static double toDouble(Object obj) {
		if ( obj instanceof Double ) {
			return (Double)obj;
		} else if ( obj instanceof Integer ) {
			return (Integer)obj;
		}
		return 0;
	}

	public static double[] toDoubleArray( int n, Object obj ) {
		double[] v = new double[n];
		ArrayList<?> a = (ArrayList<?>)obj;
		for( int i = 0 ; i < n ; ++i ) {
			v[i] = toDouble( a.size() > 0 ? a.get(i) : 0.0 );
		}
		return v;
	}
}
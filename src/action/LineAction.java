
package action;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import jofc2.model.Chart;
import jofc2.model.Text;
import jofc2.model.axis.YAxis;
import jofc2.model.elements.LineChart;

import com.opensymphony.xwork2.ActionSupport;


public class LineAction extends ActionSupport{

	private static final long serialVersionUID = -5759373192727732648L;
	
	private Chart ofcChart;

	public Chart getOfcChart() {
		return ofcChart;
	}

	public void setOfcChart(Chart ofcChart) {
		this.ofcChart = ofcChart;
	}
	
	public String dot()
	{
		List<LineChart.Dot> data1 = new ArrayList<LineChart.Dot>();
		List<LineChart.Dot> data2 = new ArrayList<LineChart.Dot>();
		List<LineChart.Dot> data3 = new ArrayList<LineChart.Dot>();
		
		for( double i = 0; i < 6.2; i+=0.2 )
		{
			//line 1 dot
			LineChart.Dot dot1 = new LineChart.Dot( Math.sin(i) * 1.9 + 10 );
			dot1.setDotSize(5);
			dot1.setColour("#f00000");
			data1.add(dot1);
			
			//line 2 dot
			LineChart.Dot dot2 = new LineChart.Dot( Math.sin(i) * 1.9 + 7 );
			dot2.setDotSize(3);
			dot2.setHaloSize(1);//点外空白大小
			dot2.setColour("#3D5C56");
			data2.add(dot2);
			
			//line 3 dot
			LineChart.Dot dot3 = new LineChart.Dot( Math.sin(i) * 1.9 + 4 );
			dot3.setDotSize(4);
			dot3.setHaloSize(2);//点外空白大小
			data3.add(dot3);
		}
		
		Date date = new Date();
		Locale locale = new Locale("zh","CN");
		DateFormat dateFormat = DateFormat.getDateInstance( DateFormat.FULL, locale );
		
		//line1 
		LineChart line1 = new LineChart();
		//line1.setDotStyle(new LineChart.Style(LineChart.Style.Type.Dot));
		line1.setWidth(1);
		line1.addDots(data1);
		
		//line2
		LineChart line2 = new LineChart();
		line2.setColour("#3D5C56");
		line2.setWidth(2);
		line2.addDots(data2);
		
		//line3
		LineChart line3 = new LineChart();
		line3.setWidth(6);
		line3.addDots(data3);
		
		YAxis y = new YAxis();
		y.setRange(0, 15, 5);//设置Y轴范围，（最小，最大，间隔）
		
		ofcChart = new Chart();
		ofcChart.setTitle(new Text(dateFormat.format(date)));
		ofcChart.addElements(line1);
		ofcChart.addElements(line2);
		ofcChart.addElements(line3);
		ofcChart.setYAxis(y);
		
		return SUCCESS;
	}
	
}

/**
 * 
 */
package myCalculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author G-Train
 * 
 */
public class SimpleCalculator extends JFrame {

	private static final long serialVersionUID = 1L;

	private int pannelWidth = 545;// 窗口的宽度
	private int pannelHeight = 745;// 窗口的长度
	private JButton zero = null;
	private JButton one = null;
	private JButton two = null;
	private JButton three = null;
	private JButton four = null;
	private JButton five = null;
	private JButton six = null;
	private JButton seven = null;
	private JButton eight = null;
	private JButton nine = null;
	private JButton point = null;
	private JButton add = null;
	private JButton minus = null;
	private JButton div = null;
	private JButton multy = null;
	private JButton delete = null;
	private JButton reset = null;
	private JButton equal = null;
	private JButton pi = null;// π键
	private JButton Scien_Cal = null;
	private int width = 130;
	private int height = 100;
	StringBuffer sb = new StringBuffer("0");
	private JTextField screen = null;
	private static int indexOfSymbol = 0;
	private int indexOfAdd;
	private int indexOfMinus;
	private int indexOfDiv;
	private int indexOfMulty;

	public SimpleCalculator() {// 构造方法
		init();
		addListener();
		assemble();
		showFrame();
		display(sb);
	}

	// 初始化框架
	private void init() {
		this.setTitle("计算器");
		Scien_Cal = new JButton("科");
		Scien_Cal.setFont(new Font("楷体", Font.PLAIN, 60));
		zero = new JButton("0");
		zero.setFont(new Font("宋体", Font.PLAIN, 80));// 设置字体、粗细和大小（默认单位为像素）
		one = new JButton("1");
		one.setFont(new Font("宋体", Font.PLAIN, 80));
		two = new JButton("2");
		two.setFont(new Font("宋体", Font.PLAIN, 80));
		three = new JButton("3");
		three.setFont(new Font("宋体", Font.PLAIN, 80));
		four = new JButton("4");
		four.setFont(new Font("宋体", Font.PLAIN, 80));
		five = new JButton("5");
		five.setFont(new Font("宋体", Font.PLAIN, 80));
		six = new JButton("6");
		six.setFont(new Font("宋体", Font.PLAIN, 80));
		seven = new JButton("7");
		seven.setFont(new Font("宋体", Font.PLAIN, 80));
		eight = new JButton("8");
		eight.setFont(new Font("宋体", Font.PLAIN, 80));
		nine = new JButton("9");
		nine.setFont(new Font("宋体", Font.PLAIN, 80));
		pi = new JButton("π");
		pi.setFont(new Font("宋体", Font.PLAIN, 80));
		point = new JButton("·");
		point.setFont(new Font("宋体", Font.PLAIN, 80));
		add = new JButton("+");
		add.setFont(new Font("宋体", Font.PLAIN, 80));
		minus = new JButton("-");
		minus.setFont(new Font("宋体", Font.PLAIN, 80));
		div = new JButton("÷");
		div.setFont(new Font("宋体", Font.PLAIN, 80));
		multy = new JButton("×");
		multy.setFont(new Font("宋体", Font.PLAIN, 80));
		delete = new JButton("←");
		delete.setFont(new Font("宋体", Font.PLAIN, 80));
		reset = new JButton("C");
		reset.setFont(new Font("宋体", Font.PLAIN, 80));
		equal = new JButton("=");
		equal.setFont(new Font("宋体", Font.PLAIN, 80));
	}

	private void hideThisWiondow() {
		this.setVisible(false);
	}

	private void addNum(int num) {
		if (sb.length() - indexOfSymbol < 12) {
			if ((((indexOfSymbol + 1) == sb.length()) && sb.charAt(sb.length() - 1) == '0')
			    || ((indexOfSymbol + 1) == sb.length() - 1)
			    && sb.charAt(sb.length() - 1) == '0') {// 如果字符串首位为0,且只有1位字符;或者运算符号后面一位为0且是最后一个字符时
				sb.deleteCharAt(sb.length() - 1);
				sb.append(num);
			} else {
				sb.append(num);
			}
		}
	}

	// 添加键盘监听
	private void addListener() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Scien_Cal.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				hideThisWiondow();
				new ScientificCalculator();
			}
		});
		zero.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if (sb.length() - indexOfSymbol < 12
				) {
					if (sb.charAt(indexOfSymbol) == '0' && sb.length() == 1) {// 如果字符串只有一个字符且为0时，无操作
					} else if (indexOfSymbol > 0 && ((indexOfSymbol + 1) == sb.length() - 1)
					    && sb.charAt(sb.length() - 1) == '0') {// 当运算符后是字符串的最后一个字符且为0时，无操作
					} else {
						sb.append(0);
					}
				}
				display(sb);
			}
		});
		one.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				addNum(1);
				display(sb);
			}
		});
		two.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				addNum(2);
				display(sb);
			}
		});
		three.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				addNum(3);
				display(sb);
			}
		});
		four.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				addNum(4);
				display(sb);
			}
		});
		five.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				addNum(5);
				display(sb);
			}
		});
		six.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				addNum(6);
				display(sb);
			}
		});
		seven.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				addNum(7);
				display(sb);
			}
		});
		eight.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				addNum(8);
				display(sb);
			}
		});
		nine.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				addNum(9);
				display(sb);
			}
		});

		pi.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if (indexOfSymbol == 0) {
					if (sb.length() == 1 && sb.charAt(0) == '0') {
						sb.deleteCharAt(0);
						sb.append("3.1416");
					} else {
						sb.append("×3.1416");
					}
				} else {
					if (indexOfSymbol == sb.length() - 1) {
						sb.append("3.1416");
					} else {
						sb.append("×3.1416");
					}
				}
				display(sb);
			}
		});
		add.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if (((sb.charAt(sb.length() - 1)) != '+')
				    && ((sb.charAt(sb.length() - 1)) != '-')
				    && ((sb.charAt(sb.length() - 1)) != '×')
				    && ((sb.charAt(sb.length() - 1)) != '÷')) {
					sb.append("+");
					indexOfAdd = sb.toString().length() - 1;
					indexOfSymbol = indexOfAdd;
				}
				display(sb);
			}
		});
		minus.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if (((sb.charAt(sb.length() - 1)) != '+')
				    && ((sb.charAt(sb.length() - 1)) != '-')
				    && ((sb.charAt(sb.length() - 1)) != '×')
				    && ((sb.charAt(sb.length() - 1)) != '÷')) {
					sb.append("-");
					indexOfMinus = sb.length() - 1;
					indexOfSymbol = indexOfMinus;
				}
				display(sb);
			}
		});
		multy.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if (((sb.charAt(sb.length() - 1)) != '+')
				    && ((sb.charAt(sb.length() - 1)) != '-')
				    && ((sb.charAt(sb.length() - 1)) != '×')
				    && ((sb.charAt(sb.length() - 1)) != '÷')) {
					sb.append("×");
					indexOfMulty = sb.length() - 1;
					indexOfSymbol = indexOfMulty;
				}
				display(sb);
			}
		});
		div.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if (((sb.charAt(sb.length() - 1)) != '+')
				    && ((sb.charAt(sb.length() - 1)) != '-')
				    && ((sb.charAt(sb.length() - 1)) != '×')
				    && ((sb.charAt(sb.length() - 1)) != '÷')) {
					sb.append("÷");
					indexOfDiv = sb.length() - 1;
					indexOfSymbol = indexOfDiv;
				}
				display(sb);
			}
		});
		point.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if (sb.length() - indexOfSymbol < 11
				    && (((sb.length() - 1) == indexOfSymbol && indexOfSymbol != 0) || sb == null)) {// 在运算符号后面或显示栏为空时自动添加0.
					sb.append("0.");
				}
				if (!sb.substring(indexOfSymbol, sb.length()).contains(".")) {// 如果运算符或第一个字符到最后一个字符之间没有小数点，则可以添加小数点
					sb.append(".");
				}
				display(sb);
			}
		});
		delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if (sb.length() > 1) {
					sb.deleteCharAt(sb.length() - 1);
					display(sb);
				} else if (sb.length() == 1) {
					sb = new StringBuffer("0");
					indexOfSymbol = 0;
					display(sb);
				}
			}
		});
		reset.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer("0");
				indexOfSymbol = 0;
				display(sb);
			}
		});
		equal.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!sb.substring(indexOfSymbol, sb.length()).contains(".")) {
					sb = sb.append('.');// 必须在算式后面追加一个小数点，否则做成可执行jar文件时equal功能必须在最后一个数字上出现小数点才能使用
				}
				String equation = sb.toString();// 将文本框内的字符串转换为等式字符串
				equation = equation.replaceAll("×", "*");// 把所有的×都替换为*
				equation = equation.replaceAll("÷", "/");// 把所有的÷都替换为/
				try {
					indexOfSymbol = 0;
					showResult(equation);
				} catch (ScriptException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void showResult(String str) throws ScriptException {// 按0.00的精确度显示最终计算结果，左对齐
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = engine.eval(str);// 将字符串算式转换成对象结果
		if (result instanceof Number) {// 将对象结果转换成数字对象
			Double num = (Double) result;// 将数字对象转换成Double对象
			double n = (double) num;// 向下转型
			if (n % 1 == 0) {
				sb = new StringBuffer(new DecimalFormat("0").format(n));// 如果结果为整型，则转为整型数字
			} else {
				sb = new StringBuffer(new DecimalFormat("0.000").format(n));// 如果结果为浮点型，则转为保留精确到千分位的小数
			}
		}
		display(sb);
	}

	/*
	 * 每次输入时使用该方法重新创建显示框文本内容
	 */
	private void display(StringBuffer sb) {
		int index = 0;
		for (int i = 0; i < sb.length(); i++) {
			if ((sb.charAt(i) == '+') || (sb.charAt(i) == '-') || (sb.charAt(i) == '×')
			    || (sb.charAt(i) == '÷')) {
				index = i;
			}
		}
		indexOfSymbol = index;
		screen = new JTextField(sb.toString());
		this.add(screen);
		screen.setBounds(10, 10, 520, 160);
		if ((sb.length() - 0) < 10) {
			screen.setHorizontalAlignment(JTextField.LEFT);// 水平左对齐
			screen.setFont(new Font("宋体", Font.PLAIN, 100));
		} else if ((sb.length() - 0) < 17) {
			screen.setHorizontalAlignment(JTextField.LEFT);
			screen.setFont(new Font("宋体", Font.PLAIN, 60));
		}
		screen.setEditable(false);
		screen.setVisible(true);
	}

	// 组装计算器界面
	private void assemble() {
		this.setLayout(null);
		this.add(Scien_Cal);
		Scien_Cal.setBounds(10, 200, width, height);
		Scien_Cal.setVisible(true);
		this.add(zero);
		zero.setBounds(10, 600, width, height);
		zero.setVisible(true);
		this.add(one);
		one.setBounds(10, 500, width, height);
		one.setVisible(true);
		this.add(two);
		two.setBounds(140, 500, width, height);
		two.setVisible(true);
		this.add(three);
		three.setBounds(270, 500, width, height);
		three.setVisible(true);
		this.add(four);
		four.setBounds(10, 400, width, height);
		four.setVisible(true);
		this.add(five);
		five.setBounds(140, 400, width, height);
		five.setVisible(true);
		this.add(six);
		six.setBounds(270, 400, width, height);
		six.setVisible(true);
		this.add(seven);
		seven.setBounds(10, 300, width, height);
		seven.setVisible(true);
		this.add(eight);
		eight.setBounds(140, 300, width, height);
		eight.setVisible(true);
		this.add(nine);
		nine.setBounds(270, 300, width, height);
		nine.setVisible(true);
		this.add(pi);
		pi.setBounds(140, 200, width, height);
		pi.setVisible(true);
		this.add(point);
		point.setBounds(140, 600, width, height);
		point.setVisible(true);
		this.add(add);
		add.setBounds(400, 300, width, height);
		add.setVisible(true);
		this.add(minus);
		minus.setBounds(400, 400, width, height);
		minus.setVisible(true);
		this.add(div);
		div.setBounds(400, 600, width, height);
		div.setVisible(true);
		this.add(multy);
		multy.setBounds(400, 500, width, height);
		multy.setVisible(true);
		this.add(delete);
		delete.setBounds(400, 200, width, height);
		delete.setVisible(true);
		this.add(reset);
		reset.setBounds(270, 200, width, height);
		reset.setVisible(true);
		this.add(equal);
		equal.setBounds(270, 600, width, height);
		equal.setVisible(true);
	}

	// 显示界面
	private void showFrame() {
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(pannelWidth, pannelHeight);
		this.setLocation(500, 150);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new SimpleCalculator();
	}
}

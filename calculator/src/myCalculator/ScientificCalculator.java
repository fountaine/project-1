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
 */

public class ScientificCalculator extends JFrame {

	private static final long serialVersionUID = 1L;

	private int pannelWidth = 735;// 窗口的宽度
	private int pannelHeight = 565;// 窗口的长度
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
	private JButton E = null;// e键
	private JButton Simple = null;// 简单计算器键
	private JButton block = null;// (键
	private JButton factorial = null;// X!阶乘键
	private JButton percent = null;// %键
	private JButton Sine = null;// sin键
	private JButton cosine = null;// cos键
	private JButton tangent = null;// tan键
	private JButton radicalSign = null;// 根号键
	private JButton logarithm = null;// log键
	private JButton naturalLogarithm = null;// ln自然对数键
	private JButton backwards = null;// 1/X倒数键
	private JButton square = null;// X²键
	private JButton cube = null;// X³键
	private JButton powerFunction = null;// y^x幂函数键
	private JButton absolute = null;// 绝对值键
	private int width = 100;
	private int height = 75;
	StringBuffer sb = new StringBuffer("0");
	private JTextField screen = null;
	private static int indexOfSymbol = 0;
	private boolean aFlag = true;
	private int indexOfabs;

	public ScientificCalculator() {// 构造方法
		init();
		addListener();
		assemble();
		showFrame();
		display(sb);
	}

	// 初始化框架
	private void init() {
		this.setTitle("科学计算器");
		zero = new JButton("0");
		zero.setFont(new Font("宋体", Font.PLAIN, 60));// 设置字体、粗细和大小（默认单位为像素）
		one = new JButton("1");
		one.setFont(new Font("宋体", Font.PLAIN, 60));
		two = new JButton("2");
		two.setFont(new Font("宋体", Font.PLAIN, 60));
		three = new JButton("3");
		three.setFont(new Font("宋体", Font.PLAIN, 60));
		four = new JButton("4");
		four.setFont(new Font("宋体", Font.PLAIN, 60));
		five = new JButton("5");
		five.setFont(new Font("宋体", Font.PLAIN, 60));
		six = new JButton("6");
		six.setFont(new Font("宋体", Font.PLAIN, 60));
		seven = new JButton("7");
		seven.setFont(new Font("宋体", Font.PLAIN, 60));
		eight = new JButton("8");
		eight.setFont(new Font("宋体", Font.PLAIN, 60));
		nine = new JButton("9");
		nine.setFont(new Font("宋体", Font.PLAIN, 60));
		pi = new JButton("π");
		pi.setFont(new Font("宋体", Font.PLAIN, 60));
		E = new JButton("e");
		E.setFont(new Font("宋体", Font.PLAIN, 60));
		Simple = new JButton("简");
		Simple.setFont(new Font("楷体", Font.PLAIN, 60));
		block = new JButton("()");
		block.setFont(new Font("宋体", Font.PLAIN, 60));
		factorial = new JButton("x!");
		factorial.setFont(new Font("宋体", Font.PLAIN, 60));
		percent = new JButton("%");
		percent.setFont(new Font("宋体", Font.PLAIN, 60));
		Sine = new JButton("sin");
		Sine.setFont(new Font("宋体", Font.PLAIN, 40));
		cosine = new JButton("cos");
		cosine.setFont(new Font("宋体", Font.PLAIN, 40));
		tangent = new JButton("tan");
		tangent.setFont(new Font("宋体", Font.PLAIN, 40));
		radicalSign = new JButton("√");
		radicalSign.setFont(new Font("宋体", Font.PLAIN, 50));
		logarithm = new JButton("log");
		logarithm.setFont(new Font("宋体", Font.PLAIN, 40));
		naturalLogarithm = new JButton("ln");
		naturalLogarithm.setFont(new Font("宋体", Font.PLAIN, 60));
		backwards = new JButton("1/x");
		backwards.setFont(new Font("宋体", Font.PLAIN, 40));
		square = new JButton("x²");
		square.setFont(new Font("宋体", Font.PLAIN, 60));
		cube = new JButton("x³");
		cube.setFont(new Font("宋体", Font.PLAIN, 60));
		powerFunction = new JButton("y^x");
		powerFunction.setFont(new Font("宋体", Font.PLAIN, 40));
		absolute = new JButton("|X|");
		absolute.setFont(new Font("宋体", Font.PLAIN, 40));
		point = new JButton("·");
		point.setFont(new Font("宋体", Font.PLAIN, 60));
		add = new JButton("+");
		add.setFont(new Font("宋体", Font.PLAIN, 60));
		minus = new JButton("-");
		minus.setFont(new Font("宋体", Font.PLAIN, 60));
		div = new JButton("÷");
		div.setFont(new Font("宋体", Font.PLAIN, 60));
		multy = new JButton("×");
		multy.setFont(new Font("宋体", Font.PLAIN, 60));
		delete = new JButton("←");
		delete.setFont(new Font("宋体", Font.PLAIN, 60));
		reset = new JButton("C");
		reset.setFont(new Font("宋体", Font.PLAIN, 60));
		equal = new JButton("=");
		equal.setFont(new Font("宋体", Font.PLAIN, 60));
	}

	private void hideThisWiondow() {// 隐藏窗口
		this.setVisible(!aFlag);
	}

	private void countPow() throws ScriptException {// 计算幂指函数
		String str = null;
		if (sb.substring(indexOfSymbol, sb.length()).contains("^")) {
			optimizeForJRE();
			if (indexOfSymbol > 0) {
				str = sb.substring(indexOfSymbol + 1, sb.length());
			} else if (indexOfSymbol == 0) {
				str = sb.substring(indexOfSymbol, sb.length());
			}
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			StringBuffer sb1 = new StringBuffer(str.substring(0, str.indexOf("^")));
			StringBuffer sb2 = new StringBuffer(str.substring(str.indexOf("^") + 1, str.length()));
			if (!sb1.toString().contains(".")) {
				sb1.append(".0");
			}
			if (!sb2.toString().contains(".")) {
				sb2.append(".0");
			}
			Object obj1 = engine.eval(sb1.toString());
			Object obj2 = engine.eval(sb2.toString());
			if (obj1 instanceof Number && obj2 instanceof Number) {
				Double D1 = (Double) obj1;
				Double D2 = (Double) obj2;
				double d1 = (double) D1;
				double d2 = (double) D2;
				double result = Math.pow(d1, d2);// 计算幂指函数的值
				if (result / 1 == 0) {
					if (indexOfSymbol > 0) {
						sb.replace(indexOfSymbol + 1, sb.length(),
						    new DecimalFormat("0").format(result));
					} else if (indexOfSymbol == 0) {
						sb.replace(indexOfSymbol, sb.length(),
						    new DecimalFormat("0").format(result));
					}
				} else {
					if (indexOfSymbol > 0) {
						sb.replace(indexOfSymbol + 1, sb.length(),
						    new DecimalFormat("0.000").format(result));
					} else if (indexOfSymbol == 0) {
						sb.replace(indexOfSymbol, sb.length(),
						    new DecimalFormat("0.000").format(result));
					}
				}
			}
		}
	}

	private void countSqrt() throws ScriptException {// 计算平方根
		String str = null;
		if (sb.substring(indexOfSymbol, sb.length()).contains("√")) {
			optimizeForJRE();
			str = sb.substring(sb.indexOf("√") + 1, sb.length());
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			Object obj = engine.eval(str.substring(0, str.length()));
			if (obj instanceof Number) {
				Double D = (Double) obj;
				double d = (double) D;
				double result = Math.sqrt(d);
				if (result / 1 == 0) {
					sb.replace(sb.indexOf("√"), sb.length(), new DecimalFormat("0").format(result));
				} else {
					sb.replace(sb.indexOf("√"), sb.length(),
					    new DecimalFormat("0.000").format(result));
				}
			}
		}
	}

	private void countSine() throws ScriptException {// 计算正弦
		String str = null;
		if (sb.substring(indexOfSymbol, sb.length()).contains("sin")) {
			optimizeForJRE();
			str = sb.substring(sb.indexOf("n") + 1, sb.length());
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			Object obj = engine.eval(str.substring(0, str.length()));
			if (obj instanceof Number) {
				Double D = (Double) obj;
				double d = (double) D;
				double result = Math.sin(d * Math.PI / 180);
				if (result / 1 == 0) {
					sb.replace(sb.indexOf("s"), sb.length(), new DecimalFormat("0").format(result));
				} else {
					sb.replace(sb.indexOf("s"), sb.length(),
					    new DecimalFormat("0.000").format(result));
				}
			}
		}
	}

	private void countCosine() throws ScriptException {// 计算余弦
		String str = null;
		if (sb.substring(indexOfSymbol, sb.length()).contains("cos")) {
			optimizeForJRE();
			str = sb.substring(sb.indexOf("s") + 1, sb.length());
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			Object obj = engine.eval(str.substring(0, str.length()));
			if (obj instanceof Number) {
				Double D = (Double) obj;
				double d = (double) D;
				double result = Math.cos(d * Math.PI / 180);
				if (result / 1 == 0) {
					sb.replace(sb.indexOf("c"), sb.length(), new DecimalFormat("0").format(result));
				} else {
					sb.replace(sb.indexOf("c"), sb.length(),
					    new DecimalFormat("0.000").format(result));
				}
			}
		}
	}

	private void countTangent() throws ScriptException {// 计算正切
		String str = null;
		if (sb.substring(indexOfSymbol, sb.length()).contains("tan")) {
			optimizeForJRE();
			str = sb.substring(sb.indexOf("n") + 1, sb.length());
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			Object obj = engine.eval(str.substring(0, str.length()));
			if (obj instanceof Number) {
				Double D = (Double) obj;
				double d = (double) D;
				double result = Math.tan(d * Math.PI / 180);
				if (result / 1 == 0) {
					sb.replace(sb.indexOf("t"), sb.length(), new DecimalFormat("0").format(result));
				} else {
					sb.replace(sb.indexOf("t"), sb.length(),
					    new DecimalFormat("0.000").format(result));
				}
			}
		}
	}

	private void countlog() throws ScriptException {// 计算对数
		String str = null;
		if (sb.substring(indexOfSymbol, sb.length()).contains("log")) {
			optimizeForJRE();
			str = sb.substring(sb.indexOf("g") + 1, sb.length());
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			Object obj = engine.eval(str.substring(0, str.length()));
			if (obj instanceof Number) {
				Double D = (Double) obj;
				double d = (double) D;
				double result = Math.log(d);
				if (result / 1 == 0) {
					sb.replace(sb.indexOf("l"), sb.length(), new DecimalFormat("0").format(result));
				} else {
					sb.replace(sb.indexOf("l"), sb.length(),
					    new DecimalFormat("0.000").format(result));
				}
			}
		}
	}

	private void countln() throws ScriptException {// 计算自然对数
		String str = null;
		if (sb.substring(indexOfSymbol, sb.length()).contains("ln")) {
			optimizeForJRE();
			str = sb.substring(sb.indexOf("n") + 1, sb.length());
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			Object obj = engine.eval(str.substring(0, str.length()));
			if (obj instanceof Number) {
				Double D = (Double) obj;
				double d = (double) D;
				double result = Math.log10(d);
				if (result / 1 == 0) {
					sb.replace(sb.indexOf("l"), sb.length(), new DecimalFormat("0").format(result));
				} else {
					sb.replace(sb.indexOf("l"), sb.length(),
					    new DecimalFormat("0.000").format(result));
				}
			}
		}
	}

	private void optimizeForJRE() {// 为JRE软件做一些优化，在末尾没有小数点的数字后面添加.0
		if (!sb.substring(indexOfSymbol, sb.length()).contains(".")) {
			sb.append(".0");
		}
	}

	private void specialCalculation() throws ScriptException {// 高级函数的计算
		changeIndexOfSymbol();
		countPow();
		countSqrt();
		countSine();
		countCosine();
		countTangent();
		countlog();
		countln();
		sb = new StringBuffer(sb);
	}

	private void changeIndexOfSymbol() {// 在必要的时候需要修改indexOfSymbol的值
		sb = new StringBuffer(sb);
		int index = 0;
		for (int i = 0; i < sb.length(); i++) {
			if ((sb.charAt(i) == '+') || (sb.charAt(i) == '-') || (sb.charAt(i) == '×')
			    || (sb.charAt(i) == '÷')) {
				index = i;
			}
		}
		indexOfSymbol = index;
	}

	private void changeString(String str) {
		if (indexOfSymbol == 0) {
			if (sb.length() == 1 && sb.charAt(0) == '0') {
				sb.deleteCharAt(0);
				sb.append(str);
			} else {
				sb.append("×" + str);
				changeIndexOfSymbol();
			}
		} else {
			if (indexOfSymbol == sb.length() - 1) {
				sb.append(str);
			} else {
				sb.append("×" + str);
				changeIndexOfSymbol();
			}
		}
	}

	private void asmd(String str) {// 加减乘除方法
		if (((sb.charAt(sb.length() - 1)) != '+')
		    && ((sb.charAt(sb.length() - 1)) != '-')
		    && ((sb.charAt(sb.length() - 1)) != '×')
		    && ((sb.charAt(sb.length() - 1)) != '÷')) {
			try {
				specialCalculation();
			} catch (ScriptException e1) {
				e1.printStackTrace();
			}
			sb.append(str);
			indexOfSymbol = sb.length() - 1;
		}
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
		Simple.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				hideThisWiondow();
				new SimpleCalculator();
			}
		});

		percent.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if (sb.length() - indexOfSymbol < 12
				) {
					if (indexOfSymbol == 0) {// 当字符串只有一个数字，没有运算符号
						if ((sb.length() == 1 && sb.charAt(0) == '0')
						) {// 当字符串只由一个0组成
							sb.deleteCharAt(0);
							sb.append("%");
						} else if (sb.charAt(sb.length() - 1) == '%') {
							sb.append("%");
						} else {// 字符串由数字组成
							sb.append("×%");
							changeIndexOfSymbol();
						}
					} else {
						if (indexOfSymbol == sb.length() - 1 || sb.charAt(sb.length() - 1) == '%') {// 字符串最后一位是运算符号
							sb.append("%");
						} else {
							sb.append("×%");
							changeIndexOfSymbol();
						}
					}
				}
				display(sb);
			}
		});

		square.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if ((sb.length() - 1) > indexOfSymbol && indexOfSymbol > 0) {// 在运算符后面必须有数字才能追加平方
					String str = sb.toString().substring((indexOfSymbol + 1), sb.length());
					sb.append("×" + str);
					changeIndexOfSymbol();
				} else if (indexOfSymbol == 0) {// 只有一位数字时追加平方
					String str = sb.toString().substring((indexOfSymbol), sb.length());
					sb.append("×" + str);
					changeIndexOfSymbol();
				}
				display(sb);
			}
		});

		cube.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if ((sb.length() - 1) > indexOfSymbol && indexOfSymbol > 0) {// 在运算符后面必须有数字才能追加立方
					String str = sb.toString().substring((indexOfSymbol + 1), sb.length());
					sb.append("×" + str + "×" + str);
					changeIndexOfSymbol();
				} else if (indexOfSymbol == 0) {// 只有一位数字时追加立方
					String str = sb.toString().substring((indexOfSymbol), sb.length());
					sb.append("×" + str + "×" + str);
					changeIndexOfSymbol();
				}
				display(sb);
			}
		});

		Sine.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				changeString("sin");
				display(sb);
			}
		});
		cosine.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				changeString("cos");
				display(sb);
			}
		});
		tangent.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				changeString("tan");
				display(sb);
			}
		});
		logarithm.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				changeString("log");
				display(sb);
			}
		});
		naturalLogarithm.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				changeString("ln");
				display(sb);
			}
		});
		absolute.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if (!sb.toString().contains("|")) {// 在字符串中不含有|符号时可根据以下条件追加
					if ((sb.length() - 1) > indexOfSymbol && indexOfSymbol > 0) {
						// 在运算符后面有数字且数字中不包含|时，追加|
						sb.append("×|");
					} else if (indexOfSymbol == 0) {// 只有一位数字且数字中不包含|时，追加绝对值×|
						sb.append("×|");
						changeIndexOfSymbol();
					} else {
						sb.append("|");
					}
					indexOfabs = sb.indexOf("|");
				} else {
					String str = sb.substring(indexOfabs + 1, sb.length());
					ScriptEngineManager manager = new ScriptEngineManager();
					ScriptEngine engine = manager.getEngineByName("js");
					Object obj;
					try {
						obj = engine.eval(str);
						if (obj instanceof Number) {
							Double ab = (Double) obj;
							ab = Math.abs(ab);
							if (ab % 1 == 0) {
								sb = sb.replace(indexOfabs, sb.length(), (new StringBuffer(
								    new DecimalFormat("0").format(ab))).toString());// 如果结果为整型，则转为整型数字
							} else {
								sb = sb.replace(indexOfabs, sb.length(), (new StringBuffer(
								    new DecimalFormat("0.000").format(ab))).toString());// 如果结果为整型，则转为整型数字
							}
							indexOfabs = 0;
						}
					} catch (ScriptException e1) {
						e1.printStackTrace();
					}
				}
				display(sb);
			}
		});
		radicalSign.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if (indexOfSymbol == 0) {
					if (sb.length() == 1 && sb.charAt(0) == '0') {
						sb.deleteCharAt(0);
						sb.append("√");
					} else {
						if (sb.substring(indexOfSymbol, sb.length()).contains("√")) {
							try {
								countSqrt();
								sb.append("×√");
							} catch (ScriptException e1) {
								e1.printStackTrace();
							}
						} else {
							sb.append("×√");
						}
						changeIndexOfSymbol();
					}
				} else {
					if (indexOfSymbol == sb.length() - 1) {
						sb.append("√");
					} else {
						if (sb.substring(indexOfSymbol, sb.length()).contains("√")) {
							try {
								countSqrt();
								sb.append("×√");
							} catch (ScriptException e1) {
								e1.printStackTrace();
							}
						} else {
							sb.append("×√");
						}
						changeIndexOfSymbol();
					}
				}
				display(sb);
			}
		});
		backwards.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if ((sb.length() - 1) > indexOfSymbol && indexOfSymbol > 0) {// 在运算符后面有数字时可追加倒数
					String str = sb.substring(indexOfSymbol + 1, sb.length());
					sb.replace(indexOfSymbol + 1, sb.length(), "1÷"
					    + str);
					changeIndexOfSymbol();
				} else if (indexOfSymbol == 0) {// 只有一位数字时追加倒数
					String str = sb.substring(indexOfSymbol, sb.length());
					sb.replace(indexOfSymbol, sb.length(), "1÷"
					    + str);
					changeIndexOfSymbol();
				}
				display(sb);
			}
		});
		powerFunction.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				if ((sb.length() - 1) > indexOfSymbol && indexOfSymbol > 0) {// 在运算符后面必须有数字才能追加幂指函数
					if (sb.substring(indexOfSymbol, sb.length()).contains("^")) {
						try {
							countPow();
							sb.append("^");
						} catch (ScriptException e1) {
							e1.printStackTrace();
						}
					} else {
						sb.append("^");
					}
				} else if (indexOfSymbol == 0) {// 只有一位数字时追加幂指函数
					if (sb.substring(indexOfSymbol, sb.length()).contains("^")) {
						try {
							countPow();
							sb.append("^");
						} catch (ScriptException e1) {
							e1.printStackTrace();
						}
					} else {
						sb.append("^");
					}
				}
				display(sb);
			}
		});
		factorial.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				optimizeForJRE();
				if ((sb.length() - 1) > indexOfSymbol && indexOfSymbol > 0) {// 在运算符后面必须有数字才能追加阶乘
					String str = sb.substring(indexOfSymbol + 1, sb.length());
					ScriptEngineManager manager = new ScriptEngineManager();
					ScriptEngine engine = manager.getEngineByName("js");
					Object lastNum;
					try {
						lastNum = engine.eval(str);
						if (lastNum instanceof Number) {// 将对象结果转换成数字对象
							Double num = (Double) lastNum;// 将数字对象转换成Double对象
							double n = (double) num;// 向下转型
							if (n % 1 == 0 && n > 0) {
								for (int i = (int) n - 1; i > 0; i--) {
									n = n * i;
								}
								sb.replace(indexOfSymbol + 1, sb.length(), (new StringBuffer(
								    new DecimalFormat("0").format(n))).toString());// 如果结果为整型，则转为整型数字
							} else if (n % 1 == 0 && n < 0) {// 必须当最后的数字是整数才能追加阶乘，否则无操作
								for (int i = (int) n + 1; i < 0; i++) {
									n = n * i;
								}
							}
						}
					} catch (ScriptException e1) {
						e1.printStackTrace();
					}// 将字符串算式转换成对象结果
				} else if (indexOfSymbol == 0) {// 只有一位数字时追加阶乘
					String str = sb.substring(indexOfSymbol, sb.length());
					ScriptEngineManager manager = new ScriptEngineManager();
					ScriptEngine engine = manager.getEngineByName("js");
					Object lastNum;
					try {
						lastNum = engine.eval(str);
						if (lastNum instanceof Number) {// 将对象结果转换成数字对象
							Double num = (Double) lastNum;// 将数字对象转换成Double对象
							double n = (double) num;// 向下转型
							if (n % 1 == 0) {
								for (int i = (int) n - 1; i > 0; i--) {
									n = n * i;
								}
								sb.replace(indexOfSymbol, sb.length(), (new StringBuffer(
								    new DecimalFormat("0").format(n))).toString());// 如果结果为整型，则转为整型数字
							} else {// 必须当数字是整数才能追加阶乘，否则无操作
							}
						}
					} catch (ScriptException e1) {
						e1.printStackTrace();
					}// 将字符串算式转换成对象结果
				}
				display(sb);
			}
		});
		block.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				int left = 0, right = 0;
				for (int j = 0; j < sb.length(); j++) {
					if (sb.toString().contains("(") || sb.toString().contains(")")) {
						left = sb.indexOf("(");
						right = sb.indexOf(")");
					}
				}
				if (left > right) {
					optimizeForJRE();
					sb.append(")");
					right = sb.indexOf(")");
					String str = sb.substring(left + 1, right);// 提取括号内的字符串
					ScriptEngineManager manager = new ScriptEngineManager();
					ScriptEngine engine = manager.getEngineByName("js");
					Object blocked;
					try {
						blocked = engine.eval(str);
						if (blocked instanceof Number) {// 将对象结果转换成数字对象
							Double num = (Double) blocked;// 将数字对象转换成Double对象
							double n = (double) num;// 向下转型
							if (n % 1 == 0) {
								sb = sb.replace(left, sb.length(), (new StringBuffer(
								    new DecimalFormat("0").format(n))).toString());// 如果结果为整型，则转为整型数字
							} else {
								sb = sb.replace(left, sb.length(), (new StringBuffer(
								    new DecimalFormat("0.000").format(n))).toString());// 如果结果为整型，则转为整型数字
							}
						}
					} catch (ScriptException e1) {
						e1.printStackTrace();
					}
				} else {
					if ((indexOfSymbol > 0 && (sb.length() - 1) > indexOfSymbol)
					    || indexOfSymbol == 0) {// 当运算符后面有数字时追加×(
						sb.append("×(");
						changeIndexOfSymbol();
					} else {
						sb.append("(");
					}
				}
				display(sb);
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
				Double Pi = Math.PI;
				changeString(Pi.toString());
				changeIndexOfSymbol();
				display(sb);
			}
		});
		E.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				Double E = Math.E;
				changeString(E.toString());
				changeIndexOfSymbol();
				display(sb);
			}
		});
		add.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				asmd("+");
				display(sb);
			}
		});
		minus.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				asmd("-");
				display(sb);
			}
		});
		multy.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				asmd("×");
				display(sb);
			}
		});
		div.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuffer(sb);
				asmd("÷");
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
				if (sb.substring(indexOfSymbol, sb.length()).contains("^")
				    || sb.substring(indexOfSymbol, sb.length()).contains("√")) {
					if ((sb.length() - 1 == sb.indexOf("^") || sb.length() - 1 == sb.indexOf("√"))) {
						sb.append("0.");
					} else if ((sb.length() - 1 == sb.indexOf("^") || sb.length() - 1 == sb
					    .indexOf("√"))
					    && ((!sb.substring(sb.indexOf("^"), sb.length()).contains(".")) || (!sb
					        .substring(sb.indexOf("√"), sb.length()).contains(".")))) {
						sb.append(".");
					}
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
				changeIndexOfSymbol();
				try {
					specialCalculation();
				} catch (ScriptException e1) {
					e1.printStackTrace();
				}
				if (!sb.substring(indexOfSymbol, sb.length()).contains(".")) {
					sb = sb.append('.');// 必须在算式后面追加一个小数点，否则做成可执行jar文件时equal功能必须在最后一个数字上出现小数点才能使用
				}
				String equation = sb.toString();// 将文本框内的字符串转换为等式字符串
				equation = equation.replaceAll("%", "0.01×");
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

	private void showResult(String str) throws ScriptException {// 小数按0.0000的精确度显示最终计算结果，左对齐
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = engine.eval(str);// 将字符串算式转换成对象结果
		if (result instanceof Number) {// 将对象结果转换成数字对象
			Double num = (Double) result;// 将数字对象转换成Double对象
			double n = (double) num;// 向下转型
			if (n % 1 == 0) {
				sb = new StringBuffer(new DecimalFormat("0").format(n));// 如果结果为整型，则转为整型数字
			} else {
				sb = new StringBuffer(new DecimalFormat("0.0000").format(n));// 如果结果为浮点型，则转为保留精确到千分位的小数
			}
		}
		display(sb);
	}

	/*
	 * 每次输入时使用该方法重新创建显示框文本内容
	 */
	private void display(StringBuffer sb) {
		screen = new JTextField(sb.toString());
		this.add(screen);
		screen.setBounds(10, 10, 710, 120);
		if ((sb.length() - 0) < 12) {
			screen.setHorizontalAlignment(JTextField.LEFT);// 水平左对齐
			screen.setFont(new Font("宋体", Font.PLAIN, 100));
		} else if ((sb.length() - 0) < 20) {
			screen.setHorizontalAlignment(JTextField.LEFT);
			screen.setFont(new Font("宋体", Font.PLAIN, 60));
		}
		screen.setEditable(false);
		screen.setVisible(true);
	}

	// 组装计算器界面
	private void assemble() {
		this.setLayout(null);
		this.add(zero);
		zero.setBounds(320, 445, width, height);
		zero.setVisible(aFlag);
		this.add(one);
		one.setBounds(320, 370, width, height);
		one.setVisible(aFlag);
		this.add(two);
		two.setBounds(420, 370, width, height);
		two.setVisible(aFlag);
		this.add(three);
		three.setBounds(520, 370, width, height);
		three.setVisible(aFlag);
		this.add(four);
		four.setBounds(320, 295, width, height);
		four.setVisible(aFlag);
		this.add(five);
		five.setBounds(420, 295, width, height);
		five.setVisible(aFlag);
		this.add(six);
		six.setBounds(520, 295, width, height);
		six.setVisible(aFlag);
		this.add(seven);
		seven.setBounds(320, 220, width, height);
		seven.setVisible(aFlag);
		this.add(eight);
		eight.setBounds(420, 220, width, height);
		eight.setVisible(aFlag);
		this.add(nine);
		nine.setBounds(520, 220, width, height);
		nine.setVisible(aFlag);
		this.add(pi);
		pi.setBounds(110, 445, width, height);
		pi.setVisible(aFlag);
		this.add(Simple);
		Simple.setBounds(320, 145, width, height);
		Simple.setVisible(aFlag);
		this.add(block);
		block.setBounds(420, 145, width, height);
		block.setVisible(aFlag);
		this.add(square);
		square.setBounds(10, 370, width, height);
		square.setVisible(aFlag);
		this.add(cube);
		cube.setBounds(110, 370, width, height);
		cube.setVisible(aFlag);
		this.add(powerFunction);
		powerFunction.setBounds(210, 370, width, height);
		powerFunction.setVisible(aFlag);
		this.add(factorial);
		factorial.setBounds(10, 145, width, height);
		factorial.setVisible(aFlag);
		this.add(percent);
		percent.setBounds(210, 145, width, height);
		percent.setVisible(aFlag);
		this.add(Sine);
		Sine.setBounds(10, 220, width, height);
		Sine.setVisible(aFlag);
		this.add(cosine);
		cosine.setBounds(110, 220, width, height);
		cosine.setVisible(aFlag);
		this.add(tangent);
		tangent.setBounds(210, 220, width, height);
		tangent.setVisible(aFlag);
		this.add(logarithm);
		logarithm.setBounds(110, 295, width, height);
		logarithm.setVisible(aFlag);
		this.add(naturalLogarithm);
		naturalLogarithm.setBounds(10, 295, width, height);
		naturalLogarithm.setVisible(aFlag);
		this.add(E);
		E.setBounds(210, 445, width, height);
		E.setVisible(aFlag);
		this.add(absolute);
		absolute.setBounds(10, 445, width, height);
		absolute.setVisible(aFlag);
		this.add(radicalSign);
		radicalSign.setBounds(110, 145, width, height);
		radicalSign.setVisible(aFlag);
		this.add(backwards);
		backwards.setBounds(210, 295, width, height);
		backwards.setVisible(aFlag);
		this.add(point);
		point.setBounds(420, 445, width, height);
		point.setVisible(aFlag);
		this.add(add);
		add.setBounds(620, 220, width, height);
		add.setVisible(aFlag);
		this.add(minus);
		minus.setBounds(620, 295, width, height);
		minus.setVisible(aFlag);
		this.add(div);
		div.setBounds(620, 445, width, height);
		div.setVisible(aFlag);
		this.add(multy);
		multy.setBounds(620, 370, width, height);
		multy.setVisible(aFlag);
		this.add(delete);
		delete.setBounds(620, 145, width, height);
		delete.setVisible(aFlag);
		this.add(reset);
		reset.setBounds(520, 145, width, height);
		reset.setVisible(aFlag);
		this.add(equal);
		equal.setBounds(520, 445, width, height);
		equal.setVisible(aFlag);
	}

	// 显示界面
	private void showFrame() {
		this.setVisible(aFlag);
		this.setResizable(!aFlag);
		this.setSize(pannelWidth, pannelHeight);
		this.setLocation(500, 150);
	}
}

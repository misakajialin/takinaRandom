package ramdom;
import java.util.ArrayList;
import java.util.Random;

/**
 * 随机数生成器类，用于生成指定范围内不重复的随机数
 */
public class RandomNumberGenerator {
    
    private ArrayList<Integer> generatedNumbers; // 已经生成的随机数列表
    private int minValue; // 随机数范围最小值
    private int maxValue; // 随机数范围最大值
    
    public void setMinAndMax(int min,int max) {
    	minValue=min;
    	maxValue=max;
    }
    /**
     * 构造函数，初始化已生成随机数列表
     */
    public RandomNumberGenerator() {
        generatedNumbers = new ArrayList<>();
    }
    
    /**
     * 生成一个随机数，并确保不重复
     * @return 随机数
     * @throws IllegalStateException 如果所有可能的随机数已经生成完毕，则抛出异常
     */
   /** public int generate() throws IllegalStateException {
        if (generatedNumbers.size() >= (maxValue - minValue + 1)) {
            throw new IllegalStateException("所有可能的随机数已经生成完毕！");
        }
        
        int randomNumber;
        Random random = new Random();
        
        do {
            randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
        } while (generatedNumbers.contains(randomNumber)); // 如果已经生成过，则重新生成
        
        generatedNumbers.add(randomNumber);
        return randomNumber;
    }
    */
    public int generate() {
        if (generatedNumbers.size() >= (maxValue - minValue + 1)) {
            this.reset();
        }
        
        int randomNumber;
        Random random = new Random();
        
        do {
            randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
        } while (generatedNumbers.contains(randomNumber)); // 如果已经生成过，则重新生成
        
        generatedNumbers.add(randomNumber);
        return randomNumber;
    }
    public int[] tenroll() {
		return null;
    	/**
    	int[] tenrolls=new int[10];
    	for (int i = 0; i < tenrolls.length; i++) { //循环十次
            int num = generate() ; //生成一个0到99之间的随机数
            boolean flag = true; //设置一个标志变量，表示是否有重复
            for (int j = 0; j < i; j++) { //遍历数组中已经赋值的元素
                if (tenrolls[j] == num) { //如果有和随机数相同的元素
                    flag = false; //修改标志变量为false
                    break; //跳出内层循环
                }
            }
            if (flag) { //如果没有重复
                tenrolls[i] = num; //将随机数赋值给数组元素
            } else { //如果有重复
                i--; //将i减一，重新生成随机数
            }
        }
		return tenrolls;
		*/
    }
    
    
    /**
     * 重置随机数生成器，清空已生成的随机数列表
     */
    public void reset() {
        generatedNumbers.clear();
    }
}

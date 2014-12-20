package com.model;



public class WordBank {
	
	static Word w1 = new Word("appropriate", "adj. 适当的，相称的\nvt. 拨出(款项); 占用", "Upon reaching an appropriate age, children are encouraged, but not forced, to \"leave the nest\".","一达到适当的年龄，孩子们就被鼓励，而不是被强迫，\"离开老窝\"。 ", "[ə'prəupriət]");
	static Word w2 = new Word("commentary", "n. 实况报道，现场解说，评论", "I should perhaps point out that Crazy Racer is not social commentary, in itself. ","需要指出的昰《疯狂的赛车》并不是一部社会评论性电影。 " ,"['kɔmən.təri]");
	static Word w3 = new Word("chronic", "adj. 长期的，慢性的，惯常的 ", "There is a chronic unemployment problem in America.","在美国存在长期失业问题。", "['krɔnik]");
	static Word w4 = new Word("plausible", "adj. 似真实合理的，似可信的", "He trotted out a most plausible story, but most of us were inclined to doubt the truth of it.","他提出了一个听起来很有道理的说法，但我们大多数人对此都持怀疑态度。 ", "['plɔ:zəbl]");
	static Word w5 = new Word("identical", "adj. 相同的，同一的", "The two systems are, in effect, identical.","这两种制度实际上一模一样。 " , "[ai'dentikəl]");
	static Word w6 = new Word("monopoly", "n. 垄断，专利，独占，控制", " The telecommunication service is a government monopoly.","电信为政府专营。 ", "[mə'nɔpəli]");
	static Word w7 = new Word("revive", "vt. 使重生，恢复精神，重新记起，唤醒\nvi. 复生", "All attempts to revive the fishing industry were foredoomed to failure.","千方百计振兴渔业注定徒劳无功。 ","[ri'vaiv]");
	static Word w8 = new Word("radioactive", "adj. 放射性的", "The radioactive material is stored in a special radiation-proof container.","放射性材料贮存在防辐射的特殊容器内。 ", "[reidiəu'æktiv]");
	static Word w9 = new Word("transfer", "n. 迁移，移动，换车\nv. 转移，调转，调任", "He intends to transfer the property to his son.","他打算把财产转让给儿子。 ", "[træns'fə:]");
	static Word w10 = new Word("resort", "n. (度假)胜地，手段，凭借\nvi. 诉诸，常去", "This place has become a famous summer resort.","这个地方已成为一个避暑胜地。 ", "[ri'zɔ:t]");
	
	static Word[] words ={w1,w2,w3,w4,w5,w6,w7,w8,w9,w10};
	static WordList wl1 = new WordList(words);
	
	
	
	private int totalcount = 30;//单词总数
	private int listcount = 3;//单词列表总数
	public static WordList[] lists = {wl1,wl1,wl1};//
	
	public static WordList getWordsList(int i){
		return lists[i];
	}
	
}

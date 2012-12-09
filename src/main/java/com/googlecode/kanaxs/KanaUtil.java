package com.googlecode.kanaxs;

import java.util.*;

public final class KanaUtil
{
	// 半角カタカナを全角カタカナにするマッピング
	private static final Map<Character, Character> H2Z = new HashMap<Character, Character>();

	// 全角カタカナを半角カタカナにするマッピング
	private static final Map<Character, Character> Z2H = new HashMap<Character, Character>();

	/**
	 * カナのタイプ保持用のEnum
	 */
	public static enum Type
	{
		HANKANA,
		ZENKANA,
		ZENALPH,
		ZENKAKU,
		HANKAKU,
		HANALPH
	};

	static
	{
		// 半角カタカナを全角カタカナにするマッピング
		H2Z.put('\uFF67','\u30A1');
		H2Z.put('\uFF68','\u30A3');
		H2Z.put('\uFF69','\u30A5');
		H2Z.put('\uFF6A','\u30A7');
		H2Z.put('\uFF6B','\u30A9');
		H2Z.put('\uFF70','\u30FC');
		H2Z.put('\uFF71','\u30A2');
		H2Z.put('\uFF72','\u30A4');
		H2Z.put('\uFF73','\u30A6');
		H2Z.put('\uFF74','\u30A8');
		H2Z.put('\uFF75','\u30AA');
		H2Z.put('\uFF76','\u30AB');
		H2Z.put('\uFF77','\u30AD');
		H2Z.put('\uFF78','\u30AF');
		H2Z.put('\uFF79','\u30B1');
		H2Z.put('\uFF7A','\u30B3');
		H2Z.put('\uFF7B','\u30B5');
		H2Z.put('\uFF7C','\u30B7');
		H2Z.put('\uFF7D','\u30B9');
		H2Z.put('\uFF7E','\u30BB');
		H2Z.put('\uFF7F','\u30BD');
		H2Z.put('\uFF80','\u30BF');
		H2Z.put('\uFF81','\u30C1');
		H2Z.put('\uFF82','\u30C4');
		H2Z.put('\uFF83','\u30C6');
		H2Z.put('\uFF84','\u30C8');
		H2Z.put('\uFF85','\u30CA');
		H2Z.put('\uFF86','\u30CB');
		H2Z.put('\uFF87','\u30CC');
		H2Z.put('\uFF88','\u30CD');
		H2Z.put('\uFF89','\u30CE');
		H2Z.put('\uFF8A','\u30CF');
		H2Z.put('\uFF8B','\u30D2');
		H2Z.put('\uFF8C','\u30D5');
		H2Z.put('\uFF8D','\u30D8');
		H2Z.put('\uFF8E','\u30DB');
		H2Z.put('\uFF8F','\u30DE');
		H2Z.put('\uFF90','\u30DF');
		H2Z.put('\uFF91','\u30E0');
		H2Z.put('\uFF92','\u30E1');
		H2Z.put('\uFF93','\u30E2');
		H2Z.put('\uFF94','\u30E4');
		H2Z.put('\uFF95','\u30E6');
		H2Z.put('\uFF95','\u30E8');
		H2Z.put('\uFF97','\u30E9');
		H2Z.put('\uFF98','\u30EA');
		H2Z.put('\uFF99','\u30EB');
		H2Z.put('\uFF9A','\u30EC');
		H2Z.put('\uFF9B','\u30ED');
		H2Z.put('\uFF9C','\u30EF');
		H2Z.put('\uFF9D','\u30F3');
		H2Z.put('\uFF9E','\u309B');
		H2Z.put('\uFF9F','\u309C');
		H2Z.put('\uFF66','\u30F2');

		// 全角カタカナを半角カタカナにするマッピング
		Z2H.put('\u30A1','\uFF67');
		Z2H.put('\u30A3','\uFF68');
		Z2H.put('\u30A5','\uFF69');
		Z2H.put('\u30A7','\uFF6A');
		Z2H.put('\u30A9','\uFF6B');
		Z2H.put('\u30FC','\uFF70');
		Z2H.put('\u30A2','\uFF71');
		Z2H.put('\u30A4','\uFF72');
		Z2H.put('\u30A6','\uFF73');
		Z2H.put('\u30A8','\uFF74');
		Z2H.put('\u30AA','\uFF75');
		Z2H.put('\u30AB','\uFF76');
		Z2H.put('\u30AD','\uFF77');
		Z2H.put('\u30AF','\uFF78');
		Z2H.put('\u30B1','\uFF79');
		Z2H.put('\u30B3','\uFF7A');
		Z2H.put('\u30B5','\uFF7B');
		Z2H.put('\u30B7','\uFF7C');
		Z2H.put('\u30B9','\uFF7D');
		Z2H.put('\u30BB','\uFF7E');
		Z2H.put('\u30BD','\uFF7F');
		Z2H.put('\u30BF','\uFF80');
		Z2H.put('\u30C1','\uFF81');
		Z2H.put('\u30C4','\uFF82');
		Z2H.put('\u30C6','\uFF83');
		Z2H.put('\u30C8','\uFF84');
		Z2H.put('\u30CA','\uFF85');
		Z2H.put('\u30CB','\uFF86');
		Z2H.put('\u30CC','\uFF87');
		Z2H.put('\u30CD','\uFF88');
		Z2H.put('\u30CE','\uFF89');
		Z2H.put('\u30CF','\uFF8A');
		Z2H.put('\u30D2','\uFF8B');
		Z2H.put('\u30D5','\uFF8C');
		Z2H.put('\u30D8','\uFF8D');
		Z2H.put('\u30DB','\uFF8E');
		Z2H.put('\u30DE','\uFF8F');
		Z2H.put('\u30DF','\uFF90');
		Z2H.put('\u30E0','\uFF91');
		Z2H.put('\u30E1','\uFF92');
		Z2H.put('\u30E2','\uFF93');
		Z2H.put('\u30E4','\uFF94');
		Z2H.put('\u30E6','\uFF95');
		Z2H.put('\u30E8','\uFF96');
		Z2H.put('\u30E9','\uFF97');
		Z2H.put('\u30EA','\uFF98');
		Z2H.put('\u30EB','\uFF99');
		Z2H.put('\u30EC','\uFF9A');
		Z2H.put('\u30ED','\uFF9B');
		Z2H.put('\u30EF','\uFF9C');
		Z2H.put('\u30F2','\uFF66');
		Z2H.put('\u30F3','\uFF9D');
		Z2H.put('\u30C3','\uFF6F');
	};

	/**
	 * コンストラクタ
	 * ユーティリティクラスのためコンストラクタは、private
	 */
	private KanaUtil(){
	};

	/**
	 * 全角カタカナを半角ｶﾀｶﾅに変換します。
	 * @return 半角ｶﾀｶﾅ文字列
	 */
	public static String toHankanaCase(String str)
	{
		int i = 0;
		int f = str.length();
		char[] chars = {0xFF9E, 0xFF9F};
		StringBuilder buffer = new StringBuilder();

		for(;i<f;i++)
		{
			char c = str.charAt(i);

			if(Z2H.containsKey(c)){
				buffer.append(Z2H.get(c));
			} else if(0x30AB <= c && c <= 0x30C9){
				buffer.append(Z2H.get((char)(c - 1))).append('\uFF9E');
			} else if(0x30CF <= c && c <= 0x30DD) {
				buffer.append(Z2H.get((char)(c - c % 3))).append(chars[c % 3 - 1]);
			} else {
				buffer.append(c);
			};
		};

		return buffer.toString();
	};

	/**
	 * 半角カタカナを全角カタカナに変換します。
	 * @return {String}
	 */
	public static String toZenkanaCase(String str)
	{
		StringBuilder buffer = new StringBuilder(str);

		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			if(H2Z.containsKey(c)){
				buffer.setCharAt(i, H2Z.get(c));
			};
		};

		return buffer.toString();
	};

	/**
	 * 全角ひらがなを全角カタカナに変換します。
	 * @return 全角カタカナ
	 */
	public static String toKatakanaCase(String str)
	{
		StringBuilder buffer = new StringBuilder(str);

		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			if(0x3041 <= c && c <= 0x3096){
				buffer.setCharAt(i, (char)(c + 0x0060));
			};
		};

		return buffer.toString();
	};

	/**
	 * 全角カタカナを全角ひらがなに変換します。
	 * @return 全角ひらがなの文字列
	 */
	public static String toHiraganaCase(String str)
	{
		StringBuilder buffer = new StringBuilder(str);

		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			if(0x30A1 <= c && c <= 0x30F6){
				buffer.setCharAt(i, (char)(c - 0x0060));
			};
		};

		return buffer.toString();
	};

	/**
	 * 全角英数字を半角英数字に変換します。
	 * @return 半角英数字文字列
	 */
	public static String toHanalphCase(String str)
	{
		StringBuilder buffer = new StringBuilder(str);

		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);

			//　【！】～【～】の範囲
			if(0xFF01 <= c && c <= 0xFF5E)
			{
				buffer.setCharAt(i, (char)(c - 0xFEE0));
				continue;
			};
			// 全角スペース
			if(c == 0x3000)
			{
				buffer.setCharAt(i, '\u0020');
				continue;
			};
		};

		return buffer.toString();
	};

	/**
	 * 半角英数字を全角英数字に変換します。
	 * @return 全角英数字
	 */
	public static String toZenalphCase(String str)
	{
		StringBuilder buffer = new StringBuilder(str);

		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);

			//　【！】～【～】の範囲
			if(c <= 0x007E && 0x0021 <= c)
			{
				buffer.setCharAt(i, (char)(c + 0xFEE0));
				continue;
			};

			// 半角スペース
			if(c == 0x0020)
			{
				buffer.setCharAt(i, '\u3000');
				continue;
			};
		};

		return buffer.toString();
	};

	public static String toZenkakuCase(String str)
	{
		int f = str.length();
		StringBuilder buffer = new StringBuilder(str);

		for(int i=0;i<f;i++)
		{
			char c = str.charAt(i);

			if(H2Z.containsKey(c)){
				buffer.setCharAt(i, H2Z.get(c));
			} else if(c == 0x0020){
				buffer.setCharAt(i, '\u3000');
			} else if(c <= 0x007E && 0x0021 <= c) {
				buffer.setCharAt(i, (char)(c + 0xFEE0));
			};

			if
			(
					(0x304B <= c && c <= 0x3062 && (c % 2 == 1)) ||
					(0x30AB <= c && c <= 0x30C2 && (c % 2 == 1)) ||
					(0x3064 <= c && c <= 0x3069 && (c % 2 == 0)) ||
					(0x30C4 <= c && c <= 0x30C9 && (c % 2 == 0))
			)
			{
					char d = buffer.charAt(i+1);
					buffer.setCharAt(i, (char)(c + ((d == '\u309B') ? 1 : 0 )));
					if(c != buffer.charAt(i))
					{
							buffer = buffer.deleteCharAt(i+1);
							f--;
					};
					continue;
			};

			if
			(
					(0x306F <= c && c <= 0x307D && (c % 3 == 0)) ||
					(0x30CF <= c && c <= 0x30DD && (c % 3 == 0))
			)
			{
					char d = buffer.charAt(i+1);
					buffer.setCharAt(i, (char)(c + ((d == '\u309B') ? 1 : ((d == '\u309C') ? 2 : 0 ))));
					if(c != buffer.charAt(i))
					{
							buffer = buffer.deleteCharAt(i+1);
							f--;
					};
					continue;
			};

		};

		return buffer.toString();
	};

	public static String toHankakuCase(String str)
	{
		int f = str.length();
		char[] chars = {0xFF9E, 0xFF9F};
		StringBuilder buffer = new StringBuilder();

		for(int i=0;i<f;i++)
		{
			char c = str.charAt(i);

			if(Z2H.containsKey(c)){
				buffer.append(Z2H.get(c));
			} else if(0x30AB <= c && c <= 0x30C9){
				buffer.append(Z2H.get((char)(c - 1))).append('\uFF9E');
			} else if(c == 0x3000) {
				buffer.append('\u0020');
			} else if(0x30CF <= c && c <= 0x30DD) {
				buffer.append(Z2H.get((char)(c - c % 3))).append(chars[c % 3 - 1]);
			} else if(0xFF01 <= c && c <= 0xFF5E) {
				buffer.append((char)(c - 0xFEE0));
			} else {
				buffer.append(c);
			};
		};

		return buffer.toString();
	};

	public static String convert(String str, KanaUtil.Type type)
	{
		switch(type)
		{
			case ZENKAKU:
				return toZenkakuCase(str);
			case HANKAKU:
				return toHankakuCase(str);
			case ZENKANA:
				return toZenkanaCase(str);
			case HANKANA:
				return toHankanaCase(str);
			case ZENALPH:
				return toZenalphCase(str);
			case HANALPH:
				return toHanalphCase(str);
		};

		return str;
	};
};

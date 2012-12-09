package com.googlecode.kanaxs
{
	public final class KanaUtil
	{
		/**
		 * 全角仮名→半角仮名への変換テーブル
		 */
		private static var $Z2H:Object =
		{
			0x30A1:0xFF67, 0x30A3:0xFF68, 0x30A5:0xFF69, 0x30A7:0xFF6A, 0x30A9:0xFF6B,
			0x30FC:0xFF70, 0x30A2:0xFF71, 0x30A4:0xFF72, 0x30A6:0xFF73, 0x30A8:0xFF74,
			0x30AA:0xFF75, 0x30AB:0xFF76, 0x30AD:0xFF77, 0x30AF:0xFF78, 0x30B1:0xFF79,
			0x30B3:0xFF7A, 0x30B5:0xFF7B, 0x30B7:0xFF7C, 0x30B9:0xFF7D, 0x30BB:0xFF7E,
			0x30BD:0xFF7F, 0x30BF:0xFF80, 0x30C1:0xFF81, 0x30C4:0xFF82, 0x30C6:0xFF83,
			0x30C8:0xFF84, 0x30CA:0xFF85, 0x30CB:0xFF86, 0x30CC:0xFF87, 0x30CD:0xFF88,
			0x30CE:0xFF89, 0x30CF:0xFF8A, 0x30D2:0xFF8B, 0x30D5:0xFF8C, 0x30D8:0xFF8D,
			0x30DB:0xFF8E, 0x30DE:0xFF8F, 0x30DF:0xFF90, 0x30E0:0xFF91, 0x30E1:0xFF92,
			0x30E2:0xFF93, 0x30E4:0xFF94, 0x30E6:0xFF95, 0x30E8:0xFF96, 0x30E9:0xFF97,
			0x30EA:0xFF98, 0x30EB:0xFF99, 0x30EC:0xFF9A, 0x30ED:0xFF9B, 0x30EF:0xFF9C,
			0x30F2:0xFF66, 0x30F3:0xFF9D, 0x30C3:0xFF6F
		};

		/**
		 * 半角仮名→全角仮名への変換テーブル
		 */
		private static var $H2Z:Object =
		{
			0xFF67:0x30A1, 0xFF68:0x30A3, 0xFF69:0x30A5, 0xFF6A:0x30A7, 0xFF6B:0x30A9,
			0xFF70:0x30FC, 0xFF71:0x30A2, 0xFF72:0x30A4, 0xFF73:0x30A6, 0xFF74:0x30A8,
			0xFF75:0x30AA, 0xFF76:0x30AB, 0xFF77:0x30AD, 0xFF78:0x30AF, 0xFF79:0x30B1,
			0xFF7A:0x30B3, 0xFF7B:0x30B5, 0xFF7C:0x30B7, 0xFF7D:0x30B9, 0xFF7E:0x30BB,
			0xFF7F:0x30BD, 0xFF80:0x30BF, 0xFF81:0x30C1, 0xFF82:0x30C4, 0xFF83:0x30C6,
			0xFF84:0x30C8, 0xFF85:0x30CA, 0xFF86:0x30CB, 0xFF87:0x30CC, 0xFF88:0x30CD,
			0xFF89:0x30CE, 0xFF8A:0x30CF, 0xFF8B:0x30D2, 0xFF8C:0x30D5, 0xFF8D:0x30D8,
			0xFF8E:0x30DB, 0xFF8F:0x30DE, 0xFF90:0x30DF, 0xFF91:0x30E0, 0xFF92:0x30E1,
			0xFF93:0x30E2, 0xFF94:0x30E4, 0xFF95:0x30E6, 0xFF95:0x30E8, 0xFF97:0x30E9,
			0xFF98:0x30EA, 0xFF99:0x30EB, 0xFF9A:0x30EC, 0xFF9B:0x30ED, 0xFF9C:0x30EF,
			0xFF9D:0x30F3, 0xFF9E:0x309B, 0xFF9F:0x309C, 0xFF66:0x30F2
		};

		/**
		 * 全角ひらがなを全角カタカナに変換します。
		 * @return {String}
		　*/
		public static function toKatakanaCase(s:String):String
		{
			var c:Number;
			var a:Array = [];
			var i:uint = s.length;
		
			while(i--)
			{
				c = s.charCodeAt(i);
				a[i] = (0x3041 <= c && c <= 0x3096) ? c + 0x0060 : c;
			};

			return String.fromCharCode.apply(null, a);
		};


		/**
		 * 全角英数字を半角英数字に変換します。
		 * @return {String}
		 */
		public static function toHankakuCase(s:String):String
		{
			var c:Number;
			var a:Array = [];
			var i:uint = s.length;

			while(i--)
			{
				c = a[i] = s.charCodeAt(i);

				switch(true)
				{
					//　【！】～【～】の範囲
					case (0xFF01 <= c && c <= 0xFF5E):
						a[i] -= 0xFEE0;
						break;
					// 全角スペース
					case (c == 0x3000):
						a[i] = 0x0020;
						break;
				};
			};

			return String.fromCharCode.apply(null, a);
		};

		/**
		 * 全角のカタカナを半角のカタカナに変換します。
		 * @return {String}
		 */
		public static function toHankanaCase(s:String):String
		{
			var c:Number;
			var a:Array = [];
			var m:Object = $Z2H;

			for(var i:uint=0,f:uint=s.length;i<f;)
			{
				c = s.charCodeAt(i++);
				switch(true)
				{
					case (c in m):
						a.push(m[c]);
						break;
					case (0x30AB <= c && c <= 0x30C9):
						a.push(m[c-1], 0xFF9E);
						break;
					case (0x30CF <= c && c <= 0x30DD):
						a.push(m[c-c%3], [0xFF9E,0xFF9F][c%3-1]);
						break;
					default:
						a.push(c);
						break;
				};
			};

			return String.fromCharCode.apply(null, a);
		};

		/**
		 * 例えば、【は゛】や【は゜】を、【ば】や【ぱ】に変換します。
		 * @return {String}
		 */
		public static function toPaddingCase(s:String):String
		{
			var c:Number;
			var a:Array = [];
		
			for(var i:uint=0,f:uint=s.length;i<f;i++)
			{
				c = s.charCodeAt(i);
				switch(true)
				{
					// か(0x304B) ～ ぢ(0x3062)
					case (0x304B <= c && c <= 0x3062 && (c % 2 == 1)):
					// カ(0x30AB) ～ ヂ(0x30C2) 
					case (0x30AB <= c && c <= 0x30C2 && (c % 2 == 1)):
					// つ(0x3064) ～ と(0x3069)
					case (0x3064 <= c && c <= 0x3069 && (c % 2 == 0)):
					// ツ(0x30C4) ～ ト(0x309C)
					case (0x30C4 <= c && c <= 0x30C9 && (c % 2 == 0)):
						a.push(c + ({0x309B:1}[s.charCodeAt(i+1)] || 0));
						if(a[a.length-1] != c){ i++; };
						break;
					// は(0x306F) ～ ぽ(0x307D)
					case (0x306F <= c && c <= 0x307D && (c % 3 == 0)):
					// ハ(0x30CF) ～ ポ(0x30DD)
					case (0x30CF <= c && c <= 0x30DD && (c % 3 == 0)):
						a.push(c + ({0x309B:1,0x309C:2}[s.charCodeAt(i+1)] || 0));
						if(a[a.length-1] != c){ i++; };
						break;
					default:
						a.push(c);
						break;
				};
			};
		
			return String.fromCharCode.apply(null, a);	
		};

		/**
		 * 半角英数字を全角英数字に変換します。
		 * @return {String}
		 */
		public static function toZenkakuCase(s:String):String
		{
			var c:Number;
			var a:Array = [];
			var i:uint = s.length;

			while(i--)
			{
				c = a[i] = s.charCodeAt(i);
				switch(true)
				{
					// 【!】～【~】の範囲
					case (0x0021 <= c && c <= 0x007E):
						a[i] += 0xFEE0;
						break;
					// 半角スペース
					case (c == 0x0020):
						a[i] = 0x3000;
						break;
				};
			};

			return String.fromCharCode.apply(null, a);
		};

		/**
		 * 全角カタカナを全角ひらがに変換します。
		 * @return {String}
		 */
		public static function toHiraganaCase(s:String):String
		{
			var c:Number;
			var a:Array = [];
			var i:uint = s.length
		
			while(i--)
			{
				c = s.charCodeAt(i);
				a[i] = (0x30A1 <= c && c <= 0x30F6) ? c - 0x0060 : c;
			};
		
			return String.fromCharCode.apply(null, a);
		};

		/**
		 * 半角のカタカナを全角のカタカナに変換します。
		 * @return {String}
		 */
		public static function toZenkanaCase(s:String):String
		{
			var c:Number;
			var a:Array = [];
			var m:Object = $H2Z;

			for(var i:uint=0,f:uint=s.length;i<f;i++)
			{
				c = s.charCodeAt(i);
				a[i] = m[c] || c;
			};

			return String.fromCharCode.apply(null, a);
		};
	};
};

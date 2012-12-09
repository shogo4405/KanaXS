/**
 * 全角英数字を半角英数字に変換します。
 * @example
 * "ａｂｃＡＢＣ１２３".toHankakuCase(); // abcABC123
 * @return {String}
 */
String.prototype.toHankakuCase = function()
{
	var c, i = this.length, a = [];

	while(i--)
	{
		c = a[i] = this.charCodeAt(i);

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

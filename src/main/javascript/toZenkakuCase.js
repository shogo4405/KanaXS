/**
 * 半角英数字を全角英数字に変換します。
 * @example
 * "abcABC123".toZenkakuCase(); // ａｂｃＡＢＣ１２３
 * @return {String}
 */
String.prototype.toZenkakuCase = function()
{
	var c, i = this.length, a = [];

	while(i--)
	{
		c = a[i] = this.charCodeAt(i);
		switch(true)
		{
			case (c <= 0x007E && 0x0021 <= c):
				a[i] += 0xFEE0;
				break;
			case (c == 0x0020):
				a[i] = 0x3000;
				break;
		};
	};

	return String.fromCharCode.apply(null, a);
};

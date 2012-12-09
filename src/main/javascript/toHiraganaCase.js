/**
 * 全角カタカナを全角ひらがに変換します。
 * @example
 * "アイウエオ".toHiraganaCase(); // あいうえお
 * @return {String}
 */
String.prototype.toHiraganaCase = function()
{
	var c, i = this.length, a = [];

	while(i--)
	{
		c = this.charCodeAt(i);
		a[i] = (0x30A1 <= c && c <= 0x30F6) ? c - 0x0060 : c;
	};

	return String.fromCharCode.apply(null, a);
};

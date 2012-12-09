/**
 * 全角ひらがなを全角カタカナに変換します。
 * @example
 * "あいうえお".toKatakanaCase(); // アイウエオ
 * @return {String}
 */
String.prototype.toKatakanaCase = function()
{
	var c, i = this.length, a = [];

	while(i--)
	{
		c = this.charCodeAt(i);
		a[i] = (0x3041 <= c && c <= 0x3096) ? c + 0x0060 : c;
	};

	return String.fromCharCode.apply(null, a);
};

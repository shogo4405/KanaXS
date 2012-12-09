
/**
 * 例えば、【は゛】や【は゜】を、【ば】や【ぱ】に変換します。
 * @example
 * "は゛".toPaddingCase(); // ば
 * @return {String}
 */
String.prototype.toPaddingCase = function()
{
	var i, c, f, a = [];

	for(i=0,f=this.length;i<f;i++)
	{
		c = this.charCodeAt(i);
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
				a.push(c + ({0x309B:1}[this.charCodeAt(i+1)] || 0));
				if(a[a.length-1] != c){ i++; };
				break;
			// は(0x306F) ～ ぽ(0x307D)
			case (0x306F <= c && c <= 0x307D && (c % 3 == 0)):
			// ハ(0x30CF) ～ ポ(0x30DD)
			case (0x30CF <= c && c <= 0x30DD && (c % 3 == 0)):
				a.push(c + ({0x309B:1,0x309C:2}[this.charCodeAt(i+1)] || 0));
				if(a[a.length-1] != c){ i++; };
				break;
			default:
				a.push(c);
				break;
		};
	};

	return String.fromCharCode.apply(null, a);
};

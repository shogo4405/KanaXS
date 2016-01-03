## KanaXSとは
半角、全角などの相互変換ライブラリーです。言語としては、Java、JavaScript、ActionScript3版があります。Swift版も公開しています。Cocoapodsに登録するために別のレポジトリーにしました。

## 変換の種類
次の変換の種類をサポートしています。
* 「全角英数字」「半角英数字」での相互変換
* 「全角ひらがな」「全角カタカナ」での相互変換
* 「全角カタカナ」「半角カタカナ」での相互変換

## 利用方法
### JavaScript
String.prototypeを拡張しています。
```html
<!-- ライブラリーの読み込み。githubのリンクするのではなくお持ち帰り推奨。 -->
<script type="text/javascript" src="/path/to/kana-X.X.X-min.js"></script>
<script type="text/javascript">
"Hello World!!".toZenkakuCase() // Ｈｅｌｌｏ　Ｗｏｒｌｄ！！
"Ｈｅｌｌｏ　Ｗｏｒｌｄ！！".toHankakuCase() // Hello World!!
"こんにちわ世界".toKatakanaCase() // コンニチワ世界
"コンニチワ世界".toHiraganaCase() // こんにちわ世界
"コンニチワ世界".toHankanaCase() // ｺﾝﾆﾁﾜ世界
"ｺﾝﾆﾁﾜ世界".toZenkanaCase() // コンニチワ世界
</script>
```

## リンク
* Swift版もあります。
 * https://github.com/shogo4405/KanaSwift
* どぼん！さんが.NETな環境でつかえるC#版を公開されています。
 * http://wiki.dobon.net/index.php?free%2FkanaxsCSharp

### ライセンス情報
New BSD Licenseです。詳しくはLICENSEを参照ください。

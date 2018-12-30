# GlobalIPGetter

## 概要

ネットワーク上での外部からのグローバルなIPを取得する．
IPは外部サイトに問い合わせる形式で取得する．
本システムで用いる外部サイト様として<http://checkip.dyndns.com/>よりIPを参照する．

本システムによりIPを取得すると，config.confファイルで設定したPort番号と":"で繋いた文字列として，クリップボードに保存される．

## 開発環境
- OS : Windows10
- 言語 : java SE 10.0.2

## ビルド&実行
- cd GlobalIPGetter
- mkdir bin
- (makeによるビルドと実行)
  - make build
  - make run
- (javacコンパイラでのビルドと実行)
  - javac -d ./bin ./src/jp/*.java
  - java -cp ./bin jp/GlobalIPGetter

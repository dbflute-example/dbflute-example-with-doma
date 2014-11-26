
# ========================================================================================
#                                                                                 Overview
#                                                                                 ========
Doma と DBFlute のコラボレーション Example です。

Doma のExampleプロジェクトに対して、
DBFluteの ReplaceSchema や SchemaHTML が使えるようになっています。


# ========================================================================================
#                                                                              Environment
#                                                                              ===========
# ----------------------------------------------------------
#                                         Compile & Database
#                                         ------------------
依存ライブラリは、Mavenで管理しています。
Eclipseであれば、M2Eが入っていれば clone するだけでコンパイルが走るはずです。
IntelliJ IDEAであれば、pom.xmlから Maven を有効にしてください。

データベースは、H2 Database を組み込みで利用します。
cloneした後、一回だけ ReplaceSchema タスクを実行してスキーマを作成してください。
DBFluteクライアント(dbflute_maihamadb)配下の manage.bat(sh) を叩き、replace-schema (0) を選択して実行。

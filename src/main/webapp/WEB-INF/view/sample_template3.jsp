<!DOCTYPE html>

<body>

	<header>
		<div class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a href="/" class="navbar-brand">Honoka</a>
					<button class="navbar-toggle" type="button" data-toggle="collapse"
						data-target="#navbar-main">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse" id="navbar-main">
					<ul class="nav navbar-nav">
						<li><a href="/">Top</a></li>
						<li class="dropdown active"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-expanded="false">Demo <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="./bootstrap-ja.html">Japanese Page</a></li>
								<li><a href="./bootstrap.html">English Page</a></li>
							</ul></li>
						<li><a href="//github.com/windyakin/Honoka/releases">Download</a></li>
						<li><a href="//github.com/windyakin/Honoka/wiki">Wiki</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>

	<div class="container">

		<div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1>Honoka</h1>
					<p class="lead">日本語も美しく表示できるBootstrapテーマ</p>
				</div>
				<div class="col-lg-4 col-md-5 col-sm-6">
					<aside class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">游ゴシックの有効・無効切り替え</h4>
						</div>
						<div class="panel-body">
							<p>
								v3.3.5から
								<code>&lt;body&gt;</code>
								に
								<code>.no-thank-yu</code>
								を指定することで游ゴシックを使わないようにすることができるようになりました。
							</p>
							<p id="anti-yu-gothic-message">
								現在デモページは游ゴシックの指定が<span class="text-primary">有効</span>になっています。
							</p>
							<div>
								<button id="anti-yu-gothic-button"
									class="btn btn-danger btn-block">游ゴシックを無効にする</button>
							</div>
						</div>
					</aside>
				</div>
			</div>
		</div>

		<!-- Navbar
  ================================================== -->
		<div class="bs-docs-section clearfix">
			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h1 id="navbar">Navbar</h1>
					</div>

					<div class="bs-component">
						<nav class="navbar navbar-default">
							<div class="container-fluid">
								<div class="navbar-header">
									<button type="button" class="navbar-toggle collapsed"
										data-toggle="collapse"
										data-target="#bs-example-navbar-collapse-1">
										<span class="sr-only">Toggle navigation</span> <span
											class="icon-bar"></span> <span class="icon-bar"></span> <span
											class="icon-bar"></span>
									</button>
									<a class="navbar-brand" href="#">Brand</a>
								</div>

								<div class="collapse navbar-collapse"
									id="bs-example-navbar-collapse-1">
									<ul class="nav navbar-nav">
										<li class="active"><a href="#">Link <span
												class="sr-only">(current)</span></a></li>
										<li><a href="#">Link</a></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
												<span class="caret"></span>
										</a>
											<ul class="dropdown-menu" role="menu">
												<li><a href="#">高坂 穂乃果</a></li>
												<li><a href="#">南 ことり</a></li>
												<li><a href="#">園田 海未</a></li>
												<li class="divider"></li>
												<li><a href="#">小泉 花陽</a></li>
												<li><a href="#">星空 凛</a></li>
												<li><a href="#">西木野 真姫</a></li>
												<li class="divider"></li>
												<li><a href="#">矢澤 にこ</a></li>
												<li><a href="#">絢瀬 絵里</a></li>
												<li><a href="#">東條 希</a></li>
											</ul></li>
									</ul>
									<form class="navbar-form navbar-left" role="search">
										<div class="form-group">
											<input type="text" class="form-control" placeholder="Search">
										</div>
										<button type="submit" class="btn btn-default">検索</button>
									</form>
									<ul class="nav navbar-nav navbar-right">
										<li><a href="#">Link</a></li>
									</ul>
								</div>
							</div>
						</nav>
					</div>

					<div class="bs-component">
						<nav class="navbar navbar-inverse">
							<div class="container-fluid">
								<div class="navbar-header">
									<button type="button" class="navbar-toggle collapsed"
										data-toggle="collapse"
										data-target="#bs-example-navbar-collapse-2">
										<span class="sr-only">Toggle navigation</span> <span
											class="icon-bar"></span> <span class="icon-bar"></span> <span
											class="icon-bar"></span>
									</button>
									<a class="navbar-brand" href="#">Brand</a>
								</div>

								<div class="collapse navbar-collapse"
									id="bs-example-navbar-collapse-2">
									<ul class="nav navbar-nav">
										<li class="active"><a href="#">Link <span
												class="sr-only">(current)</span></a></li>
										<li><a href="#">Link</a></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
												<span class="caret"></span>
										</a>
											<ul class="dropdown-menu" role="menu">
												<li><a href="#">高坂 穂乃果</a></li>
												<li><a href="#">南 ことり</a></li>
												<li><a href="#">園田 海未</a></li>
												<li class="divider"></li>
												<li><a href="#">小泉 花陽</a></li>
												<li><a href="#">星空 凛</a></li>
												<li><a href="#">西木野 真姫</a></li>
												<li class="divider"></li>
												<li><a href="#">矢澤 にこ</a></li>
												<li><a href="#">絢瀬 絵里</a></li>
												<li><a href="#">東條 希</a></li>
											</ul></li>
									</ul>
									<form class="navbar-form navbar-left" role="search">
										<div class="form-group">
											<input type="text" class="form-control" placeholder="Search">
										</div>
										<button type="submit" class="btn btn-default">検索</button>
									</form>
									<ul class="nav navbar-nav navbar-right">
										<li><a href="#">Link</a></li>
									</ul>
								</div>
							</div>
						</nav>
					</div>
					<!-- /example -->

				</div>
			</div>
		</div>


		<!-- Buttons
  ================================================== -->
		<div class="bs-docs-section">
			<div class="page-header">
				<div class="row">
					<div class="col-lg-12">
						<h1 id="buttons">Buttons</h1>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-6">

					<p class="bs-component">
						<a href="#" class="btn btn-default">Default</a> <a href="#"
							class="btn btn-primary">Primary</a> <a href="#"
							class="btn btn-success">Success</a> <a href="#"
							class="btn btn-info">Info</a> <a href="#" class="btn btn-warning">Warning</a>
						<a href="#" class="btn btn-danger">Danger</a> <a href="#"
							class="btn btn-link">Link</a>
					</p>

					<p class="bs-component">
						<a href="#" class="btn btn-default disabled">Default</a> <a
							href="#" class="btn btn-primary disabled">Primary</a> <a href="#"
							class="btn btn-success disabled">Success</a> <a href="#"
							class="btn btn-info disabled">Info</a> <a href="#"
							class="btn btn-warning disabled">Warning</a> <a href="#"
							class="btn btn-danger disabled">Danger</a> <a href="#"
							class="btn btn-link disabled">Link</a>
					</p>


					<div style="margin-bottom: 15px;">
						<div class="btn-toolbar bs-component" style="margin: 0;">
							<div class="btn-group">
								<a href="#" class="btn btn-default">Default</a> <a href="#"
									class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul>
							</div>

							<div class="btn-group">
								<a href="#" class="btn btn-primary">Primary</a> <a href="#"
									class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul>
							</div>

							<div class="btn-group">
								<a href="#" class="btn btn-success">Success</a> <a href="#"
									class="btn btn-success dropdown-toggle" data-toggle="dropdown"><span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul>
							</div>

							<div class="btn-group">
								<a href="#" class="btn btn-info">Info</a> <a href="#"
									class="btn btn-info dropdown-toggle" data-toggle="dropdown"><span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul>
							</div>

							<div class="btn-group">
								<a href="#" class="btn btn-warning">Warning</a> <a href="#"
									class="btn btn-warning dropdown-toggle" data-toggle="dropdown"><span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul>
							</div>
						</div>
					</div>

					<p class="bs-component">
						<a href="#" class="btn btn-primary btn-lg">Large button</a> <a
							href="#" class="btn btn-primary">Default button</a> <a href="#"
							class="btn btn-primary btn-sm">Small button</a> <a href="#"
							class="btn btn-primary btn-xs">Mini button</a>
					</p>

				</div>
				<div class="col-lg-6">

					<p class="bs-component">
						<a href="#" class="btn btn-default btn-lg btn-block">Block
							level button</a>
					</p>


					<div class="bs-component" style="margin-bottom: 15px;">
						<div class="btn-group btn-group-justified">
							<a href="#" class="btn btn-default">Left</a> <a href="#"
								class="btn btn-default">Middle</a> <a href="#"
								class="btn btn-default">Right</a>
						</div>
					</div>

					<div class="bs-component" style="margin-bottom: 15px;">
						<div class="btn-toolbar">
							<div class="btn-group">
								<a href="#" class="btn btn-default">1</a> <a href="#"
									class="btn btn-default">2</a> <a href="#"
									class="btn btn-default">3</a> <a href="#"
									class="btn btn-default">4</a>
							</div>

							<div class="btn-group">
								<a href="#" class="btn btn-default">5</a> <a href="#"
									class="btn btn-default">6</a> <a href="#"
									class="btn btn-default">7</a>
							</div>

							<div class="btn-group">
								<a href="#" class="btn btn-default">8</a>
								<div class="btn-group">
									<a href="#" class="btn btn-default dropdown-toggle"
										data-toggle="dropdown"> Dropdown <span class="caret"></span>
									</a>
									<ul class="dropdown-menu">
										<li><a href="#">Dropdown link</a></li>
										<li><a href="#">Dropdown link</a></li>
										<li><a href="#">Dropdown link</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<div class="bs-component">
						<div class="btn-group-vertical">
							<a href="#" class="btn btn-default">Button</a> <a href="#"
								class="btn btn-default">Button</a> <a href="#"
								class="btn btn-default">Button</a> <a href="#"
								class="btn btn-default">Button</a>
						</div>
					</div>

				</div>
			</div>
		</div>

		<!-- Typography
  ================================================== -->
		<div class="bs-docs-section">
			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h1 id="type">Typography</h1>
					</div>
				</div>
			</div>

			<!-- Headings -->

			<div class="row">
				<div class="col-lg-4">
					<div class="bs-component">
						<h1>見出し 1</h1>
						<h2>見出し 2</h2>
						<h3>見出し 3</h3>
						<h4>見出し 4</h4>
						<h5>見出し 5</h5>
						<h6>見出し 6</h6>
						<p class="lead">色は匂へど散りぬるを 我が世誰そ常ならむ。</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="bs-component">
						<h2>Example body text</h2>
						<p>
							グスコーブドリは、<a href="#">イーハトーヴ</a>の大きな森のなかに生まれました。おとうさんは、グスコーナドリという名高い木こりで、どんな大きな木でも、まるで赤ん坊を寝かしつけるようにわけなく切ってしまう人でした。
						</p>
						<p>
							<small>テキストのこの行は、細字として扱われることを意味します。</small>
						</p>
						<p>
							テキストの次のコードは、 <strong>太字のテキストとしてレンダリングされます</strong>。
						</p>
						<p>
							テキストの次のコードは、 <em>斜体のテキストとしてレンダリングされます</em>。
						</p>
						<p>
							<abbr title="Nippon Telegraph and Telephone Corporation">NTT</abbr>の日本語名称は「日本電信電話」です。
						</p>
					</div>

				</div>
				<div class="col-lg-4">
					<div class="bs-component">
						<h2>Emphasis classes</h2>
						<p class="text-muted">春はあけぼの。やうやう白くなりゆく山際、少しあかりて、紫だちたる雲の細くたなびきたる。</p>
						<p class="text-primary">夏は夜。月の頃はさらなり。闇もなほ、蛍のおほく飛びちがひたる。</p>
						<p class="text-warning">また、ただ一つ二つなど、ほのかにうち光りて行くもをかし。雨など降るもをかし。</p>
						<p class="text-danger">秋は夕暮れ。夕日のさして山の端いと近うなりたるに、烏の、寝どころへ行くとて、三つ四つ、二つ三つなど飛び急ぐさへあはれなり。</p>
						<p class="text-success">まいて、雁などのつらねたるが、いと小さく見ゆるは、いとをかし。</p>
						<p class="text-info">日入り果てて、風の音、虫の音など、はた言ふべきにあらず。</p>
					</div>

				</div>
			</div>

			<!-- Blockquotes -->

			<div class="row">
				<div class="col-lg-12">
					<h2 id="type-blockquotes">Blockquotes</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<div class="bs-component">
						<blockquote>
							<p>BootstrapはWebサイトやWebアプリケーションを作成するフリーソフトウェアツール集である。タイポグラフィ、フォーム、ボタン、ナビゲーション、その他構成要素やJavaScript用拡張などがHTML及びCSSベースのデザインテンプレートとして用意されている。</p>
							<small>出典 <cite title="Bootstrap - Wikipedia">Bootstrap
									- Wikipedia</cite></small>
						</blockquote>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="bs-component">
						<blockquote class="pull-right">
							<p>BootstrapはWebサイトやWebアプリケーションを作成するフリーソフトウェアツール集である。タイポグラフィ、フォーム、ボタン、ナビゲーション、その他構成要素やJavaScript用拡張などがHTML及びCSSベースのデザインテンプレートとして用意されている。</p>
							<small>出典 <cite title="Bootstrap - Wikipedia">Bootstrap
									- Wikipedia</cite></small>
						</blockquote>
					</div>
				</div>
			</div>
		</div>

		<!-- Tables
  ================================================== -->
		<div class="bs-docs-section">

			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h1 id="tables">Tables</h1>
					</div>

					<div class="bs-component">
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th>#</th>
									<th>カラムのタイトル</th>
									<th>カラムのタイトル</th>
									<th>カラムのタイトル</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
								</tr>
								<tr>
									<td>2</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
								</tr>
								<tr class="info">
									<td>3</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
								</tr>
								<tr class="success">
									<td>4</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
								</tr>
								<tr class="danger">
									<td>5</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
								</tr>
								<tr class="warning">
									<td>6</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
								</tr>
								<tr class="active">
									<td>7</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
									<td>カラムの内容</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- /example -->
				</div>
			</div>
		</div>

		<!-- Forms
  ================================================== -->
		<div class="bs-docs-section">
			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h1 id="forms">Forms</h1>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-6">
					<div class="well bs-component">
						<form class="form-horizontal">
							<fieldset>
								<legend>説明</legend>
								<div class="form-group">
									<label for="inputEmail" class="col-lg-2 control-label">Email</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" id="inputEmail"
											placeholder="Email">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="col-lg-2 control-label">Password</label>
									<div class="col-lg-10">
										<input type="password" class="form-control" id="inputPassword"
											placeholder="Password">
										<div class="checkbox">
											<label> <input type="checkbox"> Checkbox
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="textArea" class="col-lg-2 control-label">Textarea</label>
									<div class="col-lg-10">
										<textarea class="form-control" rows="3" id="textArea"></textarea>
										<span class="help-block">ヘルプテキストは長くすることで1行を超えて分割されるようになります。</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">Radios</label>
									<div class="col-lg-10">
										<div class="radio">
											<label> <input type="radio" name="optionsRadios"
												id="optionsRadios1" value="option1" checked=""> こっち
											</label>
										</div>
										<div class="radio">
											<label> <input type="radio" name="optionsRadios"
												id="optionsRadios2" value="option2"> あっち
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="select" class="col-lg-2 control-label">Selects</label>
									<div class="col-lg-10">
										<select class="form-control" id="select">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
										</select> <br> <select multiple="" class="form-control">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-10 col-lg-offset-2">
										<button type="reset" class="btn btn-default">キャンセル</button>
										<button type="submit" class="btn btn-primary">送信</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
				<div class="col-lg-4 col-lg-offset-1">

					<form class="bs-component">
						<div class="form-group">
							<label class="control-label" for="focusedInput">Focused
								input</label> <input class="form-control" id="focusedInput" type="text"
								value="This is focused...">
						</div>

						<div class="form-group">
							<label class="control-label" for="disabledInput">Disabled
								input</label> <input class="form-control" id="disabledInput" type="text"
								placeholder="Disabled input here..." disabled="">
						</div>

						<div class="form-group has-warning">
							<label class="control-label" for="inputWarning">Input
								warning</label> <input type="text" class="form-control"
								id="inputWarning">
						</div>

						<div class="form-group has-error">
							<label class="control-label" for="inputError">Input error</label>
							<input type="text" class="form-control" id="inputError">
						</div>

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess">Input
								success</label> <input type="text" class="form-control"
								id="inputSuccess">
						</div>

						<div class="form-group">
							<label class="control-label" for="inputLarge">Large input</label>
							<input class="form-control input-lg" type="text" id="inputLarge">
						</div>

						<div class="form-group">
							<label class="control-label" for="inputDefault">Default
								input</label> <input type="text" class="form-control" id="inputDefault">
						</div>

						<div class="form-group">
							<label class="control-label" for="inputSmall">Small input</label>
							<input class="form-control input-sm" type="text" id="inputSmall">
						</div>

						<div class="form-group">
							<label class="control-label">Input addons</label>
							<div class="input-group">
								<span class="input-group-addon">$</span> <input type="text"
									class="form-control"> <span class="input-group-btn">
									<button class="btn btn-default" type="button">Button</button>
								</span>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>

		<!-- Navs
  ================================================== -->
		<div class="bs-docs-section">

			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h1 id="nav">Navs</h1>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-4">
					<h2 id="nav-tabs">Tabs</h2>
					<div class="bs-component">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#home" data-toggle="tab">坊っちゃん</a></li>
							<li><a href="#profile" data-toggle="tab">愚見数則</a></li>
							<li class="disabled"><a>Disabled</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"> 宮沢賢治 <span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#dropdown1" data-toggle="tab">雨ニモマケズ</a></li>
									<li class="divider"></li>
									<li><a href="#dropdown2" data-toggle="tab">春と修羅(序)</a></li>
								</ul></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade active in" id="home">
								<p>親讓りの無鐵砲で小供の時から損ばかりして居る。小學校に居る時分學校の二階から飛び降りて一週間程腰を拔かした事がある。なぜそんな無闇（むやみ）をしたと聞く人があるかも知れぬ。別段深い理由でもない。新築の二階から首を出して居たら、同級生の一人が冗談に、いくら威張つても、そこから飛び降りる事は出來まい。弱虫やーい。と囃（はや）したからである。小使（こづかひ）に負ぶさつて歸つて來た時、おやぢが大きな眼をして二階位（にかいぐらゐ）から飛び降りて腰を拔かす奴があるかと云つたから、此次（このつぎ）は拔かさずに飛んで見せますと答へた。</p>
							</div>
							<div class="tab-pane fade" id="profile">
								<p>昔しの書生は、笈を負ひて四方に遊歴し、此人ならばと思ふ先生の許に落付く、故に先生を敬ふ事、父兄に過ぎたり、先生も亦弟子に対する事、真の子の如し、是でなくては真の教育といふ事は出来ぬなり、今の書生は学校を旅屋の如く思ふ、金を出して暫らく逗留するに過ぎず、厭になればすぐに宿を移す、かゝる生徒に対する校長は、宿屋の主人の如く、教師は番頭丁稚なり、主人たる校長すら、時には御客の機嫌を取らねばならず、況んや番頭丁稚をや、薫陶所か解雇されざるを以て幸福と思ふ位なり、生徒の増長し教員の下落するは当前の事なり。</p>
							</div>
							<div class="tab-pane fade" id="dropdown1">
								<p>雨ニモマケズ 風ニモマケズ 雪ニモ夏ノ暑サニモマケヌ 丈夫ナカラダヲモチ 慾ハナク 決シテ瞋ラズ
									イツモシズカニワラッテイル 一日ニ玄米四合ト 味噌ト少シノ野菜ヲタベ アラユルコトヲ ジブンヲカンジョウニ入レズニ
									ヨクミキキシワカリ ソシテワスレズ</p>
							</div>
							<div class="tab-pane fade" id="dropdown2">
								<p>わたくしといふ現象は 假定された有機交流電燈の ひとつの青い照明です （あらゆる透明な幽霊の複合体）
									風景やみんなといっしょに せはしくせはしく明滅しながら いかにもたしかにともりつづける 因果交流電燈の ひとつの青い照明です
									（ひかりはたもち、その電燈は失はれ）</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<h2 id="nav-pills">Pills</h2>
					<div class="bs-component">
						<ul class="nav nav-pills">
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#">Profile</a></li>
							<li class="disabled"><a href="#">Disabled</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"> Dropdown <span
									class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul></li>
						</ul>
					</div>
					<br>
					<div class="bs-component">
						<ul class="nav nav-pills nav-stacked">
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#">Profile</a></li>
							<li class="disabled"><a href="#">Disabled</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"> Dropdown <span
									class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4">
					<h2 id="nav-breadcrumbs">Breadcrumbs</h2>
					<div class="bs-component">
						<ul class="breadcrumb">
							<li class="active">Home</li>
						</ul>

						<ul class="breadcrumb">
							<li><a href="#">Home</a></li>
							<li class="active">Library</li>
						</ul>

						<ul class="breadcrumb">
							<li><a href="#">Home</a></li>
							<li><a href="#">Library</a></li>
							<li class="active">Data</li>
						</ul>
					</div>

				</div>
			</div>


			<div class="row">
				<div class="col-lg-4">
					<h2 id="pagination">Pagination</h2>
					<div class="bs-component">
						<ul class="pagination">
							<li class="disabled"><a href="#">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>

						<ul class="pagination pagination-lg">
							<li class="disabled"><a href="#">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>

						<ul class="pagination pagination-sm">
							<li class="disabled"><a href="#">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4">
					<h2 id="pager">Pager</h2>
					<div class="bs-component">
						<ul class="pager">
							<li><a href="#">Previous</a></li>
							<li><a href="#">Next</a></li>
						</ul>

						<ul class="pager">
							<li class="previous disabled"><a href="#">&larr; Older</a></li>
							<li class="next"><a href="#">Newer &rarr;</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4"></div>
			</div>
		</div>

		<!-- Indicators
  ================================================== -->
		<div class="bs-docs-section">

			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h1 id="indicators">Indicators</h1>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<h2>Alerts</h2>
					<div class="bs-component">
						<div class="alert alert-dismissible alert-warning">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<h4>Warning!</h4>
							<p>
								要求された処理は正常に完了できませんでした。このエラーについての詳細は<a href="#"
									class="alert-link">こちらのドキュメントを参照してください</a>.
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4">
					<div class="bs-component">
						<div class="alert alert-dismissible alert-danger">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>エラー</strong> <a href="#" class="alert-link">タイトルを入力し</a>，再度投稿を行って下さい。
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="bs-component">
						<div class="alert alert-dismissible alert-success">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>完了</strong> 記事「<a href="#" class="alert-link">国立音ノ木坂学院について</a>」を公開しました。
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="bs-component">
						<div class="alert alert-dismissible alert-info">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Tips</strong> この<a href="#" class="alert-link">アラートは気にする必要がありますが</a>,
							そんなに重要ではありません。
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4">
					<h2>Labels</h2>
					<div class="bs-component" style="margin-bottom: 40px;">
						<span class="label label-default">Default</span> <span
							class="label label-primary">Primary</span> <span
							class="label label-success">Success</span> <span
							class="label label-warning">Warning</span> <span
							class="label label-danger">Danger</span> <span
							class="label label-info">Info</span>
					</div>
				</div>
				<div class="col-lg-4">
					<h2>Badges</h2>
					<div class="bs-component">
						<ul class="nav nav-pills">
							<li class="active"><a href="#">Home <span class="badge">42</span></a></li>
							<li><a href="#">Profile <span class="badge"></span></a></li>
							<li><a href="#">Messages <span class="badge">3</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<!-- Progress bars
  ================================================== -->
		<div class="bs-docs-section">

			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h1 id="progress">Progress bars</h1>
					</div>

					<h3 id="progress-basic">Basic</h3>
					<div class="bs-component">
						<div class="progress">
							<div class="progress-bar" style="width: 60%;"></div>
						</div>
					</div>

					<h3 id="progress-alternatives">Contextual alternatives</h3>
					<div class="bs-component">
						<div class="progress">
							<div class="progress-bar progress-bar-info" style="width: 20%"></div>
						</div>

						<div class="progress">
							<div class="progress-bar progress-bar-success" style="width: 40%"></div>
						</div>

						<div class="progress">
							<div class="progress-bar progress-bar-warning" style="width: 60%"></div>
						</div>

						<div class="progress">
							<div class="progress-bar progress-bar-danger" style="width: 80%"></div>
						</div>
					</div>

					<h3 id="progress-striped">Striped</h3>
					<div class="bs-component">
						<div class="progress progress-striped">
							<div class="progress-bar progress-bar-info" style="width: 20%"></div>
						</div>

						<div class="progress progress-striped">
							<div class="progress-bar progress-bar-success" style="width: 40%"></div>
						</div>

						<div class="progress progress-striped">
							<div class="progress-bar progress-bar-warning" style="width: 60%"></div>
						</div>

						<div class="progress progress-striped">
							<div class="progress-bar progress-bar-danger" style="width: 80%"></div>
						</div>
					</div>

					<h3 id="progress-animated">Animated</h3>
					<div class="bs-component">
						<div class="progress progress-striped active">
							<div class="progress-bar" style="width: 45%"></div>
						</div>
					</div>

					<h3 id="progress-stacked">Stacked</h3>
					<div class="bs-component">
						<div class="progress">
							<div class="progress-bar progress-bar-success" style="width: 35%"></div>
							<div class="progress-bar progress-bar-warning" style="width: 20%"></div>
							<div class="progress-bar progress-bar-danger" style="width: 10%"></div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Containers
  ================================================== -->
		<div class="bs-docs-section">

			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h1 id="container">Containers</h1>
					</div>
					<div class="bs-component">
						<div class="jumbotron">
							<h1>方丈記</h1>
							<p>行く川のながれは絶えずして、しかも本の水にあらず。よどみに浮ぶうたかたは、かつ消えかつ結びて久しくとゞまることなし。世の中にある人とすみかと、またかくの如し。</p>
							<p>
								<a class="btn btn-primary btn-lg">方丈記について</a>
							</p>
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-lg-12">
					<h2>List groups</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4">
					<div class="bs-component">
						<ul class="list-group">
							<li class="list-group-item"><span class="badge">14</span>
								夢なき夢は夢じゃない</li>
							<li class="list-group-item"><span class="badge">2</span>
								Anemone heart</li>
							<li class="list-group-item"><span class="badge">1</span>
								なわとび</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="bs-component">
						<div class="list-group">
							<a href="#" class="list-group-item active"> Beat in Angel </a> <a
								href="#" class="list-group-item">にこぷり♡女子道 </a> <a href="#"
								class="list-group-item">硝子の花園 </a>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="bs-component">
						<div class="list-group">
							<a href="#" class="list-group-item">
								<h4 class="list-group-item-heading">高坂 穂乃果</h4>
								<p class="list-group-item-text">μ'sの発起人。いつも笑顔で、行動力に満ちている。</p>
							</a> <a href="#" class="list-group-item">
								<h4 class="list-group-item-heading">絢瀬 絵里</h4>
								<p class="list-group-item-text">生徒会長。才色兼備のロシア系クォーター。</p>
							</a>
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-lg-12">
					<h2>Panels</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4">
					<div class="bs-component">
						<div class="panel panel-default">
							<div class="panel-body">普通のパネル</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">パネルの見出し</div>
							<div class="panel-body">パネルの内容</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-body">パネルの内容</div>
							<div class="panel-footer">パネルのフッター</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="bs-component">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">パネルの見出し(Primary)</h3>
							</div>
							<div class="panel-body">パネルの内容</div>
						</div>

						<div class="panel panel-success">
							<div class="panel-heading">
								<h3 class="panel-title">パネルの見出し(Success)</h3>
							</div>
							<div class="panel-body">パネルの内容</div>
						</div>

						<div class="panel panel-warning">
							<div class="panel-heading">
								<h3 class="panel-title">パネルの見出し(Warning)</h3>
							</div>
							<div class="panel-body">パネルの内容</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="bs-component">
						<div class="panel panel-danger">
							<div class="panel-heading">
								<h3 class="panel-title">パネルの見出し(Danger)</h3>
							</div>
							<div class="panel-body">パネルの内容</div>
						</div>

						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">パネルの見出し(Info)</h3>
							</div>
							<div class="panel-body">パネルの内容</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<h2>Wells</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4">
					<div class="bs-component">
						<div class="well">いい感じの枠</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="bs-component">
						<div class="well well-sm">いい感じの枠(小さめ)</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="bs-component">
						<div class="well well-lg">いい感じの枠(大きめ)</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Dialogs
  ================================================== -->
		<div class="bs-docs-section">

			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h1 id="dialogs">Dialogs</h1>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<h2>Modals</h2>
					<div class="bs-component">
						<div class="modal">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">×</button>
										<h4 class="modal-title">タイトル</h4>
									</div>
									<div class="modal-body">
										<p>サンプルテキスト</p>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">閉じる</button>
										<button type="button" class="btn btn-primary">保存</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<h2>Popovers</h2>
					<div class="bs-component">
						<button type="button" class="btn btn-default"
							data-container="body" data-toggle="popover" data-placement="left"
							data-content="やうやう白くなりゆく山際、少しあかりて、紫だちたる雲の細くたなびきたる。">Left</button>

						<button type="button" class="btn btn-default"
							data-container="body" data-toggle="popover" data-placement="top"
							data-content="やうやう白くなりゆく山際、少しあかりて、紫だちたる雲の細くたなびきたる。">Top</button>

						<button type="button" class="btn btn-default"
							data-container="body" data-toggle="popover"
							data-placement="bottom"
							data-content="やうやう白くなりゆく山際、少しあかりて、紫だちたる雲の細くたなびきたる。">Bottom</button>

						<button type="button" class="btn btn-default"
							data-container="body" data-toggle="popover"
							data-placement="right"
							data-content="やうやう白くなりゆく山際、少しあかりて、紫だちたる雲の細くたなびきたる。">Right</button>
					</div>
					<h2>Tooltips</h2>
					<div class="bs-component">
						<button type="button" class="btn btn-default"
							data-toggle="tooltip" data-placement="left" title=""
							data-original-title="ツールチップだよ left">Left</button>

						<button type="button" class="btn btn-default"
							data-toggle="tooltip" data-placement="top" title=""
							data-original-title="ツールチップだよ top">Top</button>

						<button type="button" class="btn btn-default"
							data-toggle="tooltip" data-placement="bottom" title=""
							data-original-title="ツールチップだよ bottom">Bottom</button>

						<button type="button" class="btn btn-default"
							data-toggle="tooltip" data-placement="right" title=""
							data-original-title="ツールチップだよ right">Right</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="<c:url value="/js/honoka/bootstrap.min.js"/>">
	<script type="text/javascript">
  $('.bs-component [data-toggle="popover"]').popover();
  $('.bs-component [data-toggle="tooltip"]').tooltip();

  $('#anti-yu-gothic-button').on('click', function() {
    if ( $('body').hasClass('no-thank-yu') ) {
      $('body').removeClass('no-thank-yu');
      $(this).text('游ゴシックを無効にする').removeClass('btn-primary').addClass('btn-danger');
      $("#anti-yu-gothic-message").html('現在デモページは游ゴシックの指定が<span class="text-primary">有効</span>になっています。');
    }
    else {
      $('body').addClass('no-thank-yu');
      $(this).text('游ゴシックを有効にする').removeClass('btn-danger').addClass('btn-primary');
      $("#anti-yu-gothic-message").html('現在デモページは游ゴシックの指定が<span class="text-danger">無効</span>になっています。');
    }
  });
</script>
</body>


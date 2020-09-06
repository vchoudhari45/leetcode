import Document, { Html, Head, Main, NextScript, DocumentContext } from 'next/document'
import { BASEURL, HOMEPAGE, SITENAME, TWITTER_HANDLE } from '../data/menu'
import { slug } from '../util/url'

class CustomDocument extends Document {
	render() {
		const pageProps = this.props.__NEXT_DATA__.props.pageProps

		//extract fields from pageProps
		const title = pageProps.selected ? pageProps.selected.title : HOMEPAGE
		const contentArr = pageProps.content ? pageProps.content.split("\n") : ['','','']
		const metadata = contentArr[0] ? contentArr[0].replace("[comment]: metadata=", "") : ""
		const keywords = contentArr[1] ? contentArr[1].replace("[comment]: keywords=", "") : ""
		const robots = contentArr[2] ? contentArr[2].replace("[comment]: robots=", "") : ""
		const url = BASEURL + slug(title)

		//imgUrl 
		const imgUrl = BASEURL + "social-share-image.png"
		const imgWidth = "180"
		const imgHeight = "180"

		return (
			<Html lang="en">
				<Head>
					<link rel="shortcut icon" href={BASEURL + "favicon.ico"} />
					<link rel="manifest" href={BASEURL + "manifest.json"} />
					<link rel="apple-touch-icon" href={BASEURL + "apple-touch-icon.png"} />

					<meta name="theme-color" content="#FFFFFF"/>
					<meta name="viewport" content="width=device-width, initial-scale=1" />
					<meta name="description" content={metadata} />
					<meta name="keywords" content={keywords} />
					<meta name="robots" content={robots} />

					<meta key="og:locale" property="og:locale" content="en_US" />
					<meta key="og:type" property="og:type" content="website" />
					<meta key="og:title" property="og:title" content={SITENAME} />
					<meta key="og:description" property="og:description" content={metadata} />
					<meta key="og:site_name" property="og:site_name" content={SITENAME} />
					<meta key="og:url" property="og:url" content={url} />
					<meta key="og:image" property="og:image" content={imgUrl} />
					<meta key="og:image:secure_url" property="og:image:secure_url" content={imgUrl} />
					<meta key="og:image:width" property="og:image:width" content={imgWidth} />
					<meta key="og:image:height" property="og:image:height" content={imgHeight} />

					<meta key="twitter:title" name="twitter:title" content={title} />
					<meta key="twitter:description" name="twitter:description" content={metadata} />
					<meta key="twitter:card" name="twitter:card" content="summary" />
					<meta key="twitter:site" name="twitter:site" content={TWITTER_HANDLE} /> 
					<meta key="twitter:image" name="twitter:image" content={imgUrl} />
				</Head>
				<body className="text-sm md:text-base">
						<Main />
						<NextScript />
				</body>
			</Html>
		)
	}
}

CustomDocument.getInitialProps = async(context: DocumentContext) => {
  const initialProps = await Document.getInitialProps(context)
  return { ...initialProps }
}

export default CustomDocument
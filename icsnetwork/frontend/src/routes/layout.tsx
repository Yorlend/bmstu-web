import Footer from "@/components/footer"
import Header from "@/components/header"

interface Props {
  children: React.ReactNode
}

export default function RootLayout({ children }: Props): React.ReactElement<Props> {
  return (
    <div className="min-h-screen flex flex-col items-stretch justify-between bg-primary">
      <Header></Header>
      {children}
      <Footer></Footer>
    </div>
  )
}

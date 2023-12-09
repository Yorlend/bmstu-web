import React from "react";

export default function Footer(): React.ReactElement {
  return (
    <>
      <div className="grow"></div>
      <footer className="w-screen h-[150px] bg-footer flex flex-col items-center justify-center">
        <div className="font-menu font-[number:var(--menu-font-weight)] text-variable-collection-menu-font text-[length:var(--menu-font-size)] tracking-[var(--menu-letter-spacing)] leading-[var(--menu-line-height)] whitespace-nowrap [font-style:var(--menu-font-style)]">
          © 2023
        </div>
      </footer>
    </>
  )
}
import React, { useState } from 'react'

const TabsComponent = (props) => {
    const [selectedTabIndex, setSelectedTabIndex] = useState(0);
    return (
        <>
        <div style={{ margin: 30 }}>
            {props.tabItems.map((tab, i) => {
                const tabStyle={ 
                    marginRight: 20,
                    padding: 10, 
                    border: "2px solid black" 
                };
                if (selectedTabIndex === i){
                    tabStyle.backgroundColor = "black";
                    tabStyle.color = "white";
                }
                return (
                        <span onClick={(e) => {
                            setSelectedTabIndex(i)
                        }}
                            style={tabStyle}>
                            {tab.tab}
                        </span>
                )
            })}
        </div>
        <main style={{margin: "auto", padding:10, border:"1px solid black", width:500}}>
            <p>
                {props.tabItems[selectedTabIndex].content}
            </p>
        </main>
        </>
    )
}

export default TabsComponent
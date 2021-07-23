import React,{Component} from 'react'
import CheckItemList from './CheckItemList'

class CheckList extends Component{
    state ={
        itemOne:'1.	Create a new project: npx create-react-app name-the-app // after downloading cd into folder and start the app.'

    }

    

    render(){
        return(
            <div>
                <h2>hello to react</h2>
                
                <CheckItemList
                 firstItem={this.state.itemOne}
                 
                 />
            </div>
        )
    }
}

export default CheckList